package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {

    private final String userSessionAttributeName = "user";

    @Autowired
    public UserService(UserRepository userRepository) {
    }

    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute(userSessionAttributeName);
        if(user == null) {
            throw new NullPointerException("User attribute missing in session");
        }
        return user;
    }
}
