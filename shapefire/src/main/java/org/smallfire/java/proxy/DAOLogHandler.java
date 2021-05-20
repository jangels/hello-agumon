package org.smallfire.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DAOLogHandler implements InvocationHandler {
    private Object object;

    public DAOLogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("findUserById")) {
            System.out.println("proxy --- before invoke");
        }
        Object result = method.invoke(object, args);
        if (method.getName().equals("findUserById")) {
            System.out.println("proxy ---  after invoke");
        }
        return result;
    }
}
