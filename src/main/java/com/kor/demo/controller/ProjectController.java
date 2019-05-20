package com.kor.demo.controller;

import java.util.List;

import com.kor.demo.model.Project;
import com.kor.demo.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/allProjects", method=RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }
}