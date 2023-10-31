package service.lmp;

import business.Catagories;
import business.Users;

import java.util.List;

public interface ICatalogService extends IGeneric<Catagories, Long> {
    long getNewId();

    List<Catagories> findCatalogByName(String name);
    Catagories findById(long Id);
}
