package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.UserDao;
import com.teamone.easybuy.entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao=new UserDao();

    public UserService(){
    }

    public List<User> getUser() throws SQLException {
        return userDao.userList();
    }
    public boolean deleteUser(int id) throws SQLException {
        if(userDao.deleteUserByID(id)>0){
            return true;
        }else{
            return false;
        }
    }
    public User getUserInfo (int id) throws SQLException {
        return userDao.getUserByID(id);
    }
    public boolean updateUser(User user) throws SQLException {
        if(userDao.updateUser(user)>0){
            return true;
        }else{
            return false;
        }
    }
    public int getUserId(String name,String password) throws SQLException {
        User user1=userDao.getIdByNameAndPassword(name,password);
        return user1.getId();
    }
}
