package service;

import business.Users;
import config.IOFile;
import service.lmp.IUserService;
import utils.InputMethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersService implements IUserService {
    List<Users> listUsers;

    public UsersService() {
        this.listUsers = IOFile.readFromFile(IOFile.USER_PATH);
    }

    @Override
    public List<Users> findAll() {
        return listUsers;
    }

    @Override
    public Users findById(long id) {
        for (Users u : listUsers) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean save(Users users) {
        if (findById(users.getUserId()) == null) {
            //chưa, có rồi thì add
            listUsers.add(users);

        } else {
            // chỉnh sủa
            listUsers.set(listUsers.indexOf(findById(users.getUserId())), users);
        }
        IOFile.writeToFile(IOFile.USER_PATH, listUsers);

        return true;

    }

    @Override
    public void delete(Long id) {
        listUsers.remove(findById(id));
        IOFile.writeToFile(IOFile.USER_PATH, listUsers);
    }

    @Override
    public long getNewId() {
        return listUsers.stream().map(Users::getUserId).max(Comparator.naturalOrder()).orElse(0L) + 1;
    }

    @Override
    public Users login(String username, String password) {
        for (Users u : listUsers) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }


    public Users findUserByName(String name) {
        System.out.println("Input Name:: ");
        String inputUserName = InputMethods.getString().trim();
        if (listUsers.isEmpty()) {
            System.out.println("Account not registered or does not exist!");
            return null;
        }
        System.out.println("Find user information : " + inputUserName);
        for (Users users : listUsers) {
            System.out.println("\u001B[35m 🌛🌛🌛🌛🌛 User Information 🌜🌜🌜🌜🌜" +
                    "ID:" + users.getUserId() + " | Username:" + users.getUserName() + " | Name:" + users.getFullName() +
                    "\nEmail:" + users.getEmail() + " | Role:" + (users.isRole() ? "Admin" : "Customer") + " | Status:" + (users.isStatus() ? "Active" : "Baned!") +
                    "\nCreate: " + users.getCreatedAt().format(DateTimeFormatter.ISO_DATE_TIME) +
                    "\nUpdate:");
        }
        return null;
    }
}
