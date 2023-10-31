package controller;

import business.Catagories;
import business.Products;
import business.Users;
import service.ProductsService;
import service.UsersService;
import service.lmp.IProductService;

import java.util.List;

public class ProductController {

    public static IProductService productService = new ProductsService();

    public static List<Products> getListProduct() {
        List<Products> productsList = productService.findAll();
        return productsList;
    }

    public long getNewId() {
        return productService.getNewId();
    }

    public void addNewProduct(Products addProduct) {
        productService.save(addProduct);
    }

    public void editProduct(Products editProduct) {
        productService.save(editProduct);
    }

    public static List<Products> findProductByName(String name) {
        return productService.findProductByName(name);
    }

    public static void deleteProductById(long id) {
        productService.delete(id);
    }

    public static Products findById(long id) {
//        List<Products> pL = getListProduct();
//        for(Products p : pL){
//            if(p.getProductId() == id){
//                return p;
//            }
//        }
//        return null;
        return productService.findById(id);
    }

}

