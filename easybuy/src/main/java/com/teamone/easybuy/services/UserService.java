package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.UserDao;
import com.teamone.easybuy.entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao=new UserDao();
    public List<User> getUser() throws SQLException {
        return userDao.userList();
    }
}
