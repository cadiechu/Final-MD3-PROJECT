package service;

import business.Catagories;
import business.Users;
import config.IOFile;
import service.lmp.ICatalogService;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CatalogService implements ICatalogService {
    List<Catagories> catalogList;

    public CatalogService() {
        this.catalogList = IOFile.readFromFile(IOFile.CATALOG_PATH);
    }

    @Override
    public long getNewId() {
        return catalogList.stream().map(Catagories::getCatalogId).max(Comparator.naturalOrder()).orElse(0L) + 1;
    }

    @Override
    public List<Catagories> findCatalogByName(String name) {
        return catalogList.stream().filter(catagories -> catagories.getCatalogName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public List<Catagories> findAll() {
        return catalogList;
    }

    @Override
    public Catagories findById(long id) {
        return catalogList.stream().filter(catagories -> catagories.getCatalogId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean save(Catagories catagories) {
        //check ton tai
        if (findById(catagories.getCatalogId()) == null) {
            catalogList.add(catagories);

        } else {
          catalogList.set(catalogList.indexOf(findById(catagories.getCatalogId())),catagories);
        }
        //luu
        IOFile.writeToFile(IOFile.CATALOG_PATH, catalogList);
        return true;
    }

    @Override
    public void delete(Long id) {
        catalogList.remove(findById(id));
        IOFile.writeToFile(IOFile.CATALOG_PATH, catalogList);
    }
 }
