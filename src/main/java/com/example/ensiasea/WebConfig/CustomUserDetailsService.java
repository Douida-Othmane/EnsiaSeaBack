package com.example.ensiasea.WebConfig;

import com.example.ensiasea.Entity.User;
import com.example.ensiasea.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepo.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new CustomUserDetails(user);
    }

} 
