package com.springsecurityjpamysql.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurityjpamysql.daorepo.UserDao;
import com.springsecurityjpamysql.entity.UserInformation;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDao userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserInformation> user = userRepo.findByUserName(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found"+username));
		return user.map(MyUserDetails::new).get();
	}

}
