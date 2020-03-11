package com.intuit.teg.marketplace.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user) throws Exception {
      userRepository.save(user);
    }

    @Override
	@Transactional(readOnly = true)
	public Collection<User> findAllUsers() throws DataAccessException{
		return userRepository.findAll();
	}
	
}
