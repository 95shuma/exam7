package com.exam7.food_order.service;

import com.exam7.food_order.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private ClientService cs;

    @Override
    public Client loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Client> user  = Optional.ofNullable(cs.getClientByName(s));
        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return user.get();
    }
}
