package com.kor.demo.controller;

import java.util.List;

import com.kor.demo.dao.AttributeDao;
import com.kor.demo.message.request.AttributeModal;
import com.kor.demo.model.Attribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AttributeController {

    @Autowired
    private AttributeDao attributeDao;

    @RequestMapping(value = "/addcol", method = RequestMethod.POST)
    public ResponseEntity<?> addNewAttribute(@RequestBody AttributeModal addAttributeRequest) {
        if (attributeDao.existsByName(addAttributeRequest.getName())) {
            return new ResponseEntity<String>("略略略这个Column已经有了哟!", HttpStatus.BAD_REQUEST);
        }
        Attribute attribute = new Attribute(addAttributeRequest.getName());
        attributeDao.save(attribute);
        List<Attribute> attributes = attributeDao.findAll();
        return new ResponseEntity<List<Attribute>>(attributes, HttpStatus.OK);  
        // return new ResponseEntity<String>("添加成功", HttpStatus.OK);
 
    }

    @RequestMapping(value = "/addcols", method = RequestMethod.POST)
    public ResponseEntity<List<Attribute>> addManyAttributes(@RequestBody List<String> addAttributeRequest) {
        for (String name: addAttributeRequest) {
            if (!attributeDao.existsByName(name)) {
                attributeDao.save(new Attribute(name));
            }
        }
        List<Attribute> attributes = attributeDao.findAll();
        return new ResponseEntity<List<Attribute>>(attributes, HttpStatus.OK);
    }
    
}