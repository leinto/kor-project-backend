package com.kor.demo.dao;

import java.util.List;

import com.kor.demo.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer>{
    public List<Project> findAll();
}