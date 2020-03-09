package com.intuit.teg.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.Category;
import com.intuit.teg.marketplace.domain.Project;



/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
