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
 *
 * 监听器
 */
@Component
@Lazy
public class OrderEventListener {//}  implements ApplicationListener<OrderEvent> {

    // 基于注解的
    @EventListener(OrderEvent.class)
    public void onApplicationEvent(OrderEvent event) {
        if(event.getName().equals("减库存")){
            System.out.println("减库存.......");
        }
    }

}
