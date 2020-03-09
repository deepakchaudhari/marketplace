/**package com.intuit.teg.marketplace.web.rest;

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

import com.intuit.teg.marketplace.domain.UserType;
import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.service.UserTypeService;
import com.intuit.teg.marketplace.service.UserService;

@RestController
@RequestMapping("/api/userType")
public class UserTypeResource {

    private final Logger log = LoggerFactory.getLogger(UserTypeResource.class);

    @Autowired
    private UserTypeService userTypeService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserType> addUserType(@RequestBody @Valid UserType userType,  BindingResult bindingResult) throws Exception {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (userType == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<UserType>(userType, headers, HttpStatus.BAD_REQUEST);
        }

        this.userTypeService.saveUserType(userType);
        log.debug("UserType created :"+userType.getName());
        return new ResponseEntity<UserType>(userType, headers, HttpStatus.CREATED);
   
    }

   
}**/
