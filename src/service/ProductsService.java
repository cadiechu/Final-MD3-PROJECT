package service;

import business.Products;
import config.IOFile;
import service.lmp.IProductService;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsService implements IProductService {
    public List<Products> productsList;
    public ProductsService() {
        this.productsList = IOFile.readFromFile(IOFile.PRODUCT_PATH);
    }

    @Override
    public List<Products> findAll() {
        return productsList;
    }

    @Override
    public Products findById(long id) {

        return productsList.stream().filter(products -> products.getProductId() == id).findFirst().orElse(null);

    }

    @Override
    public boolean save(Products products) {
        if (findById(products.getProductId()) == null) {
            //add
            productsList.add(products);
        } else {
            //edit
            productsList.set(productsList.indexOf(findById(products.getProductId())), products);
        }
        IOFile.writeToFile(IOFile.PRODUCT_PATH,productsList);
        return true;
    }

    @Override
    public void delete(Long id) {
        productsList.remove(findById(id));
        IOFile.writeToFile(IOFile.PRODUCT_PATH, productsList);
    }

    public long getNewId(){
        Long PL = productsList.stream().map(Products::getProductId).max(Comparator.naturalOrder()).orElse(0L) + 1;
        return PL;

    }


    @Override
    public List<Products> findProductByName(String name) {
        return productsList.stream().filter(products -> products.getProductName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public void editProductDetails(long id) {

    }
}
