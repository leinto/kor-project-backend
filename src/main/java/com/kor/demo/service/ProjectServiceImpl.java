package com.kor.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kor.demo.dao.ProjectDao;
import com.kor.demo.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    @Transactional
    public List<Project> getAllProjects() {
        List<Project> projects = projectDao.findAll();
        return projects;
    }
    
}