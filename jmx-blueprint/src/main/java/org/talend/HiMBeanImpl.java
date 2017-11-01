package org.talend;

public class HiMBeanImpl implements HiMBean {

    public void sayHello() {  
        System.out.println("Hello," + getName());  
    }  
    
    public String getName() {  
        return "myName";  
    }  


}