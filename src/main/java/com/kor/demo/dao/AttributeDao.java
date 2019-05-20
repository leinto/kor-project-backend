package com.kor.demo.dao;

import java.util.List;

import com.kor.demo.model.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeDao extends JpaRepository<Attribute, Integer>{
    public List<Attribute> findAll();
    public Boolean existsByName(String Name);
}