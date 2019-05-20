package com.kor.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.kor.demo.dao.AttributeDao;
import com.kor.demo.dao.ResourceDao;
import com.kor.demo.model.Attribute;
import com.kor.demo.model.Resource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Autowired
    private AttributeDao attributeDao;

    @Override
    @Transactional
    public List<Resource> getAllResources() {
        List<Resource> resources = resourceDao.findAll();
        return resources;
    }

    @Override
    @Transactional
    public JSONObject getResources() {
        List<Resource> rawResources = resourceDao.findAll();
        List<Attribute> rawAttributes = attributeDao.findAll();
        JSONObject resources = new JSONObject();
        resources.put("resources", rawResources);
        resources.put("attributes", rawAttributes);
        // System.out.println(resources);
        return resources;
    }
    
}