package controller;

import business.Users;
import run.UsersManagerment;
import service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersController {
    public static UsersService usersService = new UsersService();

    public static Users login(String username, String password) {
        return usersService.login(username, password);
    }
    public static List<Users> getUsersList() {
        List<Users> Ul = usersService.findAll();
//        Ul.add()
        return Ul;

    }

    public void save(Users users) {
        usersService.save(users);
    }

    public static void findUserByName(String name) {
        List<Users> Ul = usersService.findAll();
        for( Users users: Ul){
            if(users.getUserName().equals(name)){
                users.displayData();
            }
        }
    }

    public void delete(long id) {
        usersService.delete(id);
    }

    public Users findById(long id) {
        return usersService.findById(id);
    }


}
