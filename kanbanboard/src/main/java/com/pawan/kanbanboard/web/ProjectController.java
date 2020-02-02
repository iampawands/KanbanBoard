package com.pawan.kanbanboard.web;

import com.pawan.kanbanboard.domain.Project;
import com.pawan.kanbanboard.services.MapErrorValidationService;
import com.pawan.kanbanboard.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.logging.LogManager;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapErrorValidationService mapErrorValidationService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project1, BindingResult bindingResult){
        ResponseEntity<?> responseEntity = mapErrorValidationService.getErrorMap(bindingResult);
        if(responseEntity!=null) return responseEntity;

        Project project = projectService.saveOrUpdate(project1);
        return new ResponseEntity<Project>(project,HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);
        System.out.println(project);
        return new ResponseEntity<Project>(project,HttpStatus.OK);
    }
}
