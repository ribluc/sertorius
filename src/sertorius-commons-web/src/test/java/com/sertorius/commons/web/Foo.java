package com.sertorius.commons.web;

import java.io.Serializable;


class Foo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    
    public Foo() {
        super();
    }
    
    public Foo(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public String toString() {
        return "Foo:{id=" + this.id + ", name=" + this.name + "}";
    }
}
