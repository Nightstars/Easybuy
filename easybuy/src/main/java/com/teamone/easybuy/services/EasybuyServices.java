package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.EasybuyDao;
import com.teamone.easybuy.entities.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;

public class EasybuyServices {
    EasybuyDao easybuyDao=new EasybuyDao();
    public boolean login(String username,String password) throws SQLException {
        User user=easybuyDao.selectUserByNameAndPwd(username, DigestUtils.sha256Hex(password));
        if(user!=null){
            return true;
        }else {
            return false;
        }
    }
    public boolean regist(User user) throws SQLException {
        if(easybuyDao.insertUser(user)>0){
            return true;
        }else {
            return false;
        }
    }
}
