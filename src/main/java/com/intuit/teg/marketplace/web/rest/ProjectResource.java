package com.intuit.teg.marketplace.web.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.teg.marketplace.domain.Bid;
import com.intuit.teg.marketplace.domain.BidDTO;
import com.intuit.teg.marketplace.domain.Project;
import com.intuit.teg.marketplace.domain.ProjectDTO;
import com.intuit.teg.marketplace.domain.User;
import com.intuit.teg.marketplace.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectResource {

    private final Logger log = LoggerFactory.getLogger(ProjectResource.class);

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProjectDTO> addProject(@RequestBody @Valid ProjectDTO project,  BindingResult bindingResult) throws Exception {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (project == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<ProjectDTO>(project, headers, HttpStatus.BAD_REQUEST);
        }

        this.projectService.saveProject(project);
        log.debug("Project created :"+project.getProjectName());
        return new ResponseEntity<ProjectDTO>(project, headers, HttpStatus.CREATED);
   
    }
    
    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Optional<Project>> getProject(@PathVariable("projectId") int projectId){
		Optional<Project> project = projectService.findProjectById(projectId);
		if(project == null){
			return new ResponseEntity<Optional<Project>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Optional<Project>>(project, HttpStatus.OK);
	}
    
    
    @RequestMapping(value = "/{projectId}/minBidAmount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   	public ResponseEntity<Project> getProjectWithMinBidAmount(@PathVariable("projectId") int projectId){
   		Project project = projectService.findProjectByIdWithMinBidAmount(projectId);
   		if(project == null){
   			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
   		}
   		return new ResponseEntity<Project>(project, HttpStatus.OK);
   	}
    
    
    
    
    @RequestMapping(value = "/{projectId}/getBidWinner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   	public ResponseEntity<Bid> getBidWinner(@PathVariable("projectId") int projectId){
   		Bid bid = projectService.findBidWinnerByprojectId(projectId);
   		if(bid == null){
   			return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
   		}
   		return new ResponseEntity<Bid>(bid, HttpStatus.OK);
   	}

   
}
