package config;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class IOFile {
    public static final String USER_PATH = "src/data/users.txt";
    public static final String CATALOG_PATH = "src/data/catalog.txt";
    public static final String PRODUCT_PATH = "src/data/product.txt";
    public static final String CART_PATH = "src/data/cart.txt";
    public static final String ORDER_PATH = "src/data/order.txt";
    public static final String ORDERDETAIL_PATH = "src/data/orderdetail.txt";

    public static <T> List<T> readFromFile(String path) {
        List<T> list = new ArrayList<>();
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    public static <T> void writeToFile(String path, List<T> list) {
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
        } catch (IOException e) {
//            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
