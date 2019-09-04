package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.EasybuyDao;
import com.teamone.easybuy.entities.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeService {
    EasybuyDao easybuyDao=new EasybuyDao();
    public List<Type> parTypeList() throws SQLException {
        List<Type> parTypeList=easybuyDao.selectParentType();
        return parTypeList;
    }
    public List<Type> childTypeList() throws SQLException {
        List<Type> childTypeList=easybuyDao.selectParentType();
        return childTypeList;
    }
}
