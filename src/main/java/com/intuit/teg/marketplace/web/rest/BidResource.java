package com.intuit.teg.marketplace.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.BidDTO;
import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.service.BidService;
import com.intuit.teg.marketplace.service.UserService;

@RestController
@RequestMapping("/api/bid")
public class BidResource {

    private final Logger log = LoggerFactory.getLogger(BidResource.class);

    @Autowired
    private BidService bidService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BidDTO> addBid(@RequestBody @Valid BidDTO bid,  BindingResult bindingResult) throws Exception {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (bid == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<BidDTO>(bid, headers, HttpStatus.BAD_REQUEST);
        }
        this.bidService.saveBid(bid);
        
        log.debug("Bid created :"+bid.getBidAmount());
        return new ResponseEntity<BidDTO>(bid, headers, HttpStatus.CREATED);
   
    }

   
}
