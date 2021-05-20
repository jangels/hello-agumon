package org.smallfire.java.proxy;

import java.io.Console;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;
import java.util.Scanner;

public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        AbstractUserDAO userDAO = new UserDAO();
        InvocationHandler handler = new DAOLogHandler(userDAO);
        AbstractUserDAO proxy = (AbstractUserDAO) Proxy.newProxyInstance(AbstractUserDAO.class.getClassLoader(),
                new Class[] {AbstractUserDAO.class}, handler);

        System.out.println(Objects.equals(userDAO, proxy));
        System.out.println("userDAO = " + userDAO);
        System.out.println("proxy = " + proxy);
        System.out.println("userDAO.getClass() = " + userDAO.getClass());
        System.out.println("proxy.getClass() = " + proxy.getClass());
        System.out.println("userDAO.hashCode() = " + userDAO.hashCode());
        System.out.println("proxy.hashCode() = " + proxy.hashCode());


//        Thread.sleep(100000000);

    }
}
