package com.intuit.teg.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.domain.UserType;



/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
