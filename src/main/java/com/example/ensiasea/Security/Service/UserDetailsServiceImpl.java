// package com.example.ensiasea.Security.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.example.ensiasea.Entity.User;
// import com.example.ensiasea.Repository.UserRepo;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {

// @Autowired
// UserRepo userRepository;

// @Override
// @Transactional
// public UserDetails loadUserByUsername(String username) throws
// UsernameNotFoundException {
// User user = userRepository.findUserByUsername(username)
// .orElseThrow(() -> new UsernameNotFoundException("User Not Found with
// username: " + username));
// return new UserDetailsImpl(user);
// }
// }