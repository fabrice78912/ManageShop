package com.example.managershop.security;


import com.example.managershop.entities.Personne;
import com.example.managershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class userDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne user= accountService.loadUserByUsername(username);
        if(user==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities= new ArrayList<>();
        ((com.example.managershop.entities.User)user).getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getNameRole()));
        });
        return new User(user.getNamePerson(), ((com.example.managershop.entities.User) user).getPassword(),authorities);

    }
}
