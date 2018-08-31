package com.lahtinen.jaakko.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lahtinen.jaakko.controller.UserRepository;
import com.lahtinen.jaakko.data.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User currentUser = repository.findByUsername(username);
		System.out.println(currentUser);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
				currentUser.getPasswordHash(), AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
}
