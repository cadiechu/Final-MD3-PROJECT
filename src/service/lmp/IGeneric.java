package service.lmp;
import business.Users;

import java.util.List;

public interface IGeneric<T, E> {
    List<T> findAll();

    boolean save(T t);

    void delete(E id);
}
