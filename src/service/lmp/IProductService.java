package service.lmp;

import business.Products;

import java.util.List;

public interface IProductService extends IGeneric<Products, Long> {
    Products findById(long id);

    List<Products> findAll();

//    void delete(long id);

    long getNewId();

    List<Products> findProductByName(String name);

}

