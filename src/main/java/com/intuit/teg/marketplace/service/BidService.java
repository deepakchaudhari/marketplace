package com.intuit.teg.marketplace.service;

import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.BidDTO;

public interface BidService {

    void saveBid(BidDTO bid) throws Exception;
    Bid createUser(BidDTO bidDTO) throws Exception;
}
