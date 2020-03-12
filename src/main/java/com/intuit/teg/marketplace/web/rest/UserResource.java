package com.intuit.teg.marketplace.web.rest;

import java.util.Collection;

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

import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> addUser(@RequestBody @Valid User user,  BindingResult bindingResult) throws Exception {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (user == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<User>(user, headers, HttpStatus.BAD_REQUEST);
        }

        this.userService.saveUser(user);
        log.debug("User created :"+user.getUsername());
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }
    

   @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<User>> getUsers(){
		Collection<User> users = this.userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}

   
}
