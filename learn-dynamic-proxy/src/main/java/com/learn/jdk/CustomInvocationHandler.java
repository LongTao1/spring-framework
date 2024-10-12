package com.learn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
	//target代表被代理类的实例对象
	Object target;

	//通过构造方法将代理对象的目标对象赋值给target
	public CustomInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] args) throws Throwable {
		//实现增强代码的地方，这里就用一个简单的打印语句代替一下了
		System.out.println("Before method: " + method.getName());

		//执行目标方法，这里是基于反射机制来实现的
		Object returnValue = method.invoke(target, args);

		//实现增强代码的地方，这里就用一个简单的打印语句代替一下了
		System.out.println("After method: " + method.getName());

		//返回目标方法的返回值
		return returnValue;
	}
}
