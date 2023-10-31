package service.lmp;

import business.Users;

import java.util.List;

public interface IUserService extends IGeneric<Users, Long> {
    Users login(String username, String password);

    List<Users> findAll();

    Users findById(long id);


    long getNewId();

    Users findUserByName(String name);

}
