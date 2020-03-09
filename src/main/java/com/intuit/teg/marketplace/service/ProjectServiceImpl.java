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
import com.intuit.teg.marketplace.domain.Project;
import com.intuit.teg.marketplace.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private  ProjectRepository  projectRepository;

    @Override
    @Transactional
    public void saveProject(Project  project) throws Exception {
    	 projectRepository.save(project);
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
}
