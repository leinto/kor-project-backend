package com.kor.demo.message.request;

import javax.validation.constraints.NotBlank;

public class ResourceRequest {

    @NotBlank
    private String attributes;

    /**
     * @return the attributes
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    

}