package org.smallfire.java.arch.sourcecode.spring.ioc.aop;


import org.omg.CORBA.ARG_OUT;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DecoratingProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Created by xsls on 2019/6/10.
 */
@Component
public class TulingCalculate implements Calculate {

    public int add(int numA, int numB) {

        System.out.println("执行目标方法:add");
        return numA+numB;
    }

    public int sub(int numA, int numB) {
        System.out.println("执行目标方法:reduce");
        return numA-numB;
    }

    public int div(int numA, int numB) {
        System.out.println("执行目标方法:div");
        return numA/numB;
    }

    public int multi(int numA, int numB) {
        System.out.println("执行目标方法:multi");

        return numA*numB;
    }

    public int mod(int numA,int numB){
        System.out.println("执行目标方法:mod");

		int retVal = ((Calculate)AopContext.currentProxy()).add(numA,numB);
        //int retVal = this.add(numA,numB);

        return retVal%numA;

        //return numA%numB;
    }

}
