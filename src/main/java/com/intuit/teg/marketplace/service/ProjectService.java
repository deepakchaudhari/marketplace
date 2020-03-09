package com.intuit.teg.marketplace.service;

import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.intuit.teg.marketplace.domain.Project;

public interface ProjectService {

    void saveProject(Project project) throws Exception;
    Optional<Project> findProjectById(long id) throws DataAccessException;
    Project findProjectByIdWithMinBidAmount(long id) throws DataAccessException;
}
