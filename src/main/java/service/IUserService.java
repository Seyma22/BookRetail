package service;

import model.User;
import java.util.ArrayList;

public interface IUserService {

    //bütün user lar
    public ArrayList<User> findAll();

    //user ekle
    public User saveUser();

    //user sil
    public void deleteUser(User user);

    //user güncelle
    public User updateUser(User user);
}