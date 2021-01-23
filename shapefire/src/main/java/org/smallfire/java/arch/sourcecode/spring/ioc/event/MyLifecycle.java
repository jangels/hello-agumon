package org.smallfire.java.arch.sourcecode.spring.ioc.event;

import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Component
public class MyLifecycle implements  SmartLifecycle   {
    private boolean started = false;
    public boolean isRunning() {
        return started;
    }

    /**
     * 主要在该方法中启动任务或者其他异步服务，
     * 比如开启MQ接收消息当上下文被刷新（所有对象已被实例化和初始化之后）时
     */
    public void start() {
        System.err.println("MyLifecycle starting");
        started = true;
    }
    public void stop() {
        System.err.println("MyLifecycle stopping");
        started = false;
    }

     @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("stop callback");
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
