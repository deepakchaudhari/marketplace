package com.intuit.teg.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.teg.marketplace.domain.UserType;
import com.intuit.teg.marketplace.repository.UserTypeRepository;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    @Transactional
    public void saveUserType(UserType userType) throws Exception {
      userTypeRepository.save(userType);
    }
}
