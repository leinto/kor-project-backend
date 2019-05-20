package com.kor.demo.dao;

import java.util.List;

import com.kor.demo.model.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDao extends JpaRepository<Resource, Integer>{
    public List<Resource> findAll();
    public Boolean existsByAttributes(String newAttributes);
}