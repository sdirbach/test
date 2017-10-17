package org.talend.esb;

public class Car {

    private String name;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void init() {
        System.out.println("init Car ...");
    }

}
