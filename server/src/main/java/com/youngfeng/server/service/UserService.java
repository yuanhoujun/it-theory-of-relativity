package com.youngfeng.server.service;

import com.youngfeng.server.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        return null != userDAO.findByUsername(username);
    }

    public boolean isExist(String username, String pwd) {
        return null != userDAO.findUser(username, pwd);
    }

    public void saveUser(String username, String pwd) {
        this.userDAO.insert(username, pwd);
    }
}
