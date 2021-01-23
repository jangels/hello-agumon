package org.smallfire.java.arch.sourcecode.spring.ioc.event;

import org.springframework.context.ApplicationEvent;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 * 事件
 */
public class OrderEvent  extends ApplicationEvent {

    private String name;

    public OrderEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}