package com.kor.demo.service;

import java.util.List;

import com.kor.demo.model.Resource;

import org.json.JSONObject;

public interface ResourceService {

    public List<Resource> getAllResources();
    public JSONObject getResources();
}