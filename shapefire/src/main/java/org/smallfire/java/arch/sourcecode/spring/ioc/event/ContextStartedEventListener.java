package org.smallfire.java.arch.sourcecode.spring.ioc.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Component
public class ContextStartedEventListener {

    @EventListener(ContextStartedEvent.class)
    public void onApplicationEvent(ContextStartedEvent event)  {
        if(event.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
        {

            //Thread.sleep(5000);
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.out.println("\n\n\n\n\n______________\n\n\n启动了\n\n_________\n\n");
        }

    }
}
