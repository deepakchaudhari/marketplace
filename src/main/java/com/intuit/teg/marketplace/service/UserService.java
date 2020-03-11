package com.intuit.teg.marketplace.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.intuit.teg.marketplace.domain.User;

public interface UserService {

    void saveUser(User user) throws Exception;

	Collection<User> findAllUsers() throws DataAccessException;;
}
