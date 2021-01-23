package org.smallfire.java.arch.jvm.classloader;

import com.sun.crypto.provider.DESKeyFactory;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyCustomClassLoader {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(MyCustomClassLoader.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        public static void main(String args[]) throws Exception {
            MyClassLoader classLoader = new MyClassLoader("D:/test");
            //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
            Class clazz = classLoader.loadClass("com.tuling.jvm.User1");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("sout", null);
            method.invoke(obj, null);
            System.out.println(clazz.getClassLoader().getClass().getName());
        }
    }

}


