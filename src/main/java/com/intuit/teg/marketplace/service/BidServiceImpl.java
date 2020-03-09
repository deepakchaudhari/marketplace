package com.intuit.teg.marketplace.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.BidDTO;
import com.intuit.teg.marketplace.domain.Project;
import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.repository.BidRepository;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProjectService projectService;

    @Override
    @Transactional
    public void saveBid(BidDTO bidDTO) throws Exception {
      Bid bid = createUser(bidDTO);
      bidRepository.save(bid);
    }
    
	@Override
	public Bid createUser(BidDTO bidDTO) throws Exception {
		Bid bid = new Bid();
		User bidUser =bidDTO.getUser();
		Optional<Project> projectObj = projectService.findProjectById(bidDTO.getProjectID());
		Project project = projectObj.get();
		bid.setBidAmount(bidDTO.getBidAmount());
		bid.setUser(bidUser);
		bid.setDate(bidDTO.getDate());
		bid.setDescProposal(bidDTO.getDescProposal());
		bid.setEstimatedDays(bidDTO.getEstimatedDays());
		bid.setProject(project);
		return bid;
	}
	
	
// Future enhancemnet for the Auto-Bid Feature
	
/**
	@Override
	public Bid createUser(BidDTO bidDTO) throws Exception {
		Bid bid = new Bid();
		User bidUser =bidDTO.getUser();
		//Project project = projectService.findProjectByIdWithMinBidAmount(bidDTO.getProjectID());
		Optional<Project> projectObj = projectService.findProjectById(bidDTO.getProjectID());
		Project project = projectObj.get();
		
		if(bidUser.getAutoBidEnabled() ) {
			BigDecimal minBidAmount =  project.getLowestBidAmount();
			if(-1 == minBidAmount.compareTo(bidDTO.getBidAmount())) {
			BigDecimal percentageConst = new BigDecimal(10);
			BigDecimal hundred = new BigDecimal(100);
			BigDecimal divBidAmount = percentageConst.divide(minBidAmount);
			BigDecimal bidAmount = divBidAmount.multiply(hundred);
			
			if(-1 == bidAmount.compareTo(bidUser.getAutoBidMin())) {
				bid.setBidAmount(minBidAmount.subtract(bidAmount));
			}else {
				bid.setBidAmount(bidDTO.getBidAmount());
			}
			}
			else {
				bid.setBidAmount(bidDTO.getBidAmount());
			}
		}
		
		bid.setUser(bidUser);
		bid.setDate(bidDTO.getDate());
		bid.setDescProposal(bidDTO.getDescProposal());
		bid.setEstimatedDays(bidDTO.getEstimatedDays());
		bid.setProject(project);
		return bid;
	}
	
	**/
	
}
