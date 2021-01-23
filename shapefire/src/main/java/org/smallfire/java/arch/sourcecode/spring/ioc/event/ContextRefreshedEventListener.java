package org.smallfire.java.arch.sourcecode.spring.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Component
public class ContextRefreshedEventListener{ //implements ApplicationListener<ContextRefreshedEvent> {

    //@Async
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event)  {
        if(event.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
        {
            System.out.println("______________\n容器加载完毕\n———————");
        }

    }

}
