package com.kor.demo.controller;

import java.util.List;

import com.kor.demo.dao.ResourceDao;
import com.kor.demo.message.request.ResourceRequest;
import com.kor.demo.model.Resource;
import com.kor.demo.service.ResourceService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceDao resourceDao;

    @RequestMapping(value = "/allResources", method = RequestMethod.GET)
    public ResponseEntity<List<Resource>> getAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return new ResponseEntity<List<Resource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public ResponseEntity<String> getResources() {
        JSONObject resources = resourceService.getResources();
        // System.out.println(resources);
        return new ResponseEntity<String>(resources.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addrow", method = RequestMethod.POST)
    public ResponseEntity<?> addNewResource(@RequestBody ResourceRequest newRow) {
        if (resourceDao.existsByAttributes(newRow.getAttributes())) {
            return new ResponseEntity<String>("略略略这个Resource已经有了哟!", HttpStatus.BAD_REQUEST);
        }
        Resource resource = new Resource(newRow.getAttributes());
        resourceDao.save(resource);
        List<Resource> resources = resourceDao.findAll();
        return new ResponseEntity<List<Resource>>(resources, HttpStatus.OK);
    }

    @RequestMapping(value = "/addrows", method = RequestMethod.POST)
    public ResponseEntity<List<Resource>> addManyResources(@RequestBody List<String> newManyRows) {
        for (String attributes: newManyRows) {
            System.out.println(attributes);
            if (!resourceDao.existsByAttributes(attributes)) {
                resourceDao.save(new Resource(attributes));
            }
        }
        List<Resource> resources = resourceDao.findAll();
        return new ResponseEntity<List<Resource>>(resources, HttpStatus.OK);
    }

}