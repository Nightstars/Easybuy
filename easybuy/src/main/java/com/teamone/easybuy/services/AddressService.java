package com.teamone.easybuy.services;

import com.teamone.easybuy.dao.AddressDao;
import com.teamone.easybuy.entities.Address;

import java.sql.SQLException;

public class AddressService {
    AddressDao addressDao=new AddressDao();
    public boolean addAddress(Address address) throws SQLException {
        if(addressDao.insertAddress(address)>0){
            return true;
        }else {
            return false;
        }
    }
}
