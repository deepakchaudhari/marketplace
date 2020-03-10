package com.intuit.teg.marketplace.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.BidDTO;
import com.intuit.teg.marketplace.domain.Project;
import com.intuit.teg.marketplace.domain.ProjectDTO;
import com.intuit.teg.marketplace.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private  ProjectRepository  projectRepository;

    @Override
    @Transactional
    public Project saveProject(ProjectDTO  project) throws Exception {
    	Project projectObj = createProject(project);
    	Project saveProject = projectRepository.save(projectObj);
    	return saveProject;
    }
    
    public Project createProject(ProjectDTO project) throws Exception {
    	
    	Project projectObj = new Project();
    	projectObj.setDescription(project.getDescription());
    	projectObj.setMaxBudget(project.getMaxBudget());
    	projectObj.setProjectName(project.getProjectName());
    	projectObj.setSubmitionLastDay(project.getSubmitionLastDay());
    	projectObj.setUser(project.getUser());
    	return projectObj;
  	}
    
	@Override
	@Transactional(readOnly = true)
	public Optional<Project> findProjectById(long id) throws DataAccessException {
		Optional<Project> project = null;
		try {
			project = projectRepository.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		return project;
	}

	@Override
	public Project findProjectByIdWithMinBidAmount(long id) throws DataAccessException {
		Optional<Project> project = null;
		try {
			project = projectRepository.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		
		Project proObj = project.get();
		
		if(proObj!=null) {
			Set<Bid> bids = proObj.getBids();
			Bid bid = Collections.min(bids, Comparator.comparing(s -> s.getBidAmount()));
			proObj.setLowestBidAmount(bid.getBidAmount());
		}
		return proObj;
	}

	@Override
	public Bid findBidWinnerByprojectId(long id) throws DataAccessException {
		Optional<Project> project = null;
		Bid bid = null;
		try {
			project = projectRepository.findById(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			return null;
		}
		
		Project proObj = project.get();
		
		if(proObj!=null) {
			Set<Bid> bids = proObj.getBids();
			bid = Collections.min(bids, Comparator.comparing(s -> s.getBidAmount()));
			proObj.setLowestBidAmount(bid.getBidAmount());
		}
		return bid;
	}
}
