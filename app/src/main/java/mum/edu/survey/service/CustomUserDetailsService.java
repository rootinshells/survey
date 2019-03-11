package com.hellokoding.springboot.service;

import com.hellokoding.springboot.model.Admin;
import com.hellokoding.springboot.model.CustomUserDetails;
import com.hellokoding.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        java.util.logging.Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("UserCheck");
        Optional<Admin> byName = adminRepo.findByUserName(s);

        byName.orElseThrow(() -> new UsernameNotFoundException("Username not found") );
//        byName.ifPresent(adminUsers -> {
//            new CustomUserDetails(adminUsers);
//        });

        return byName.map(CustomUserDetails::new).get();
    }
}
