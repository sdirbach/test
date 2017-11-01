package org.talend;

public class AppleImpl implements Apple {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void smile() {
        System.out.println("smile ...");
    }

    public void init() {
        System.out.println("init Apple ...");
    }

}
