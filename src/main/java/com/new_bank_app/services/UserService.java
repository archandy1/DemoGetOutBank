package com.new_bank_app.services;

import com.new_bank_app.models.User;
import com.new_bank_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found.";


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }


    private final String userSessionAttributeName = "user";

    @Autowired
    public UserService(UserRepository userRepository, UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }


    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute(userSessionAttributeName);
        if(user == null) {
            throw new NullPointerException("User attribute missing in session");
        }
        return user;
    }
}
