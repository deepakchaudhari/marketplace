package com.intuit.teg.marketplace.web.rest;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;
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
import com.intuit.teg.marketplace.domain.Project;
import com.intuit.teg.marketplace.domain.ProjectDTO;
import com.intuit.teg.marketplace.service.ProjectService;

@RestController
@RequestMapping("/api/v1/project")
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

    
    @RequestMapping(value = "/{projectId}/bidWinner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   	public ResponseEntity<Bid> getBidWinner(@PathVariable("projectId") int projectId){
   		Bid bid = projectService.findBidWinnerByprojectId(projectId);
   		if(bid == null){
   			return new ResponseEntity<Bid>(HttpStatus.NOT_FOUND);
   		}
   		return new ResponseEntity<Bid>(bid, HttpStatus.OK);
   	}
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Project>> getProjects(){
		Collection<Project> projects = this.projectService.findAllProjects();
		if(projects.isEmpty()){
			return new ResponseEntity<Collection<Project>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Project>>(projects, HttpStatus.OK);
	}
    
    
    @RequestMapping(value = "/{projectId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional
	public ResponseEntity<Void> deleteProject(@PathVariable("projectId") Long projectId){
		Optional<Project> project = this.projectService.findProjectById(projectId);
		if(!project.isPresent()){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		this.projectService.deleteProject(projectId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
    // TODO 
    //UpdateProject
    /**
    @RequestMapping(value = "/{projectId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Optional<Project>> updateProject(@PathVariable("projectId") int projectId, @RequestBody @Valid Project project, BindingResult bindingResult){
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors() || (project == null)){
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Optional<Project>>(headers, HttpStatus.BAD_REQUEST);
		}
		Optional<Project> currentProject = this.projectService.findProjectById(projectId);
		if(currentProject == null){
			return new ResponseEntity<Optional<Project>>(HttpStatus.NOT_FOUND);
		}
		currentProject.
		
		
		return new ResponseEntity<Optional<Project>>(currentProject, HttpStatus.NO_CONTENT);
	}**/

   
}
