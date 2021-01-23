package org.smallfire.java.arch.sourcecode.spring.ioc.ioc;


import org.springframework.stereotype.Component;

@Component
public class Tank {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tank() {
        System.out.println("tank 加载....");
    }

}
