package com.intuit.teg.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.teg.marketplace.domain.Role;
import com.intuit.teg.marketplace.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private  RoleRepository  roleRepository;

    @Override
    @Transactional
    public void saveRole(Role role) throws Exception {
    	 roleRepository.save(role);
    }
}
