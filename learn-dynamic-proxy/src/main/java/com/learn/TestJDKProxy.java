package com.learn;


import com.learn.jdk.CustomInvocationHandler;
import com.learn.jdk.IPersonService;
import com.learn.jdk.PersonService;

import java.lang.reflect.Proxy;

public class TestJDKProxy {
	public static void main(String[] args) {
		//生成出来的代理实现了IUserService接口，这就是为什么上面的方法一定要传入目标对象(UserService)实现的接口IUserService
		IPersonService personService = (IPersonService) Proxy.newProxyInstance(
				//目标对象(UserService)的类加载器，负责向内存中加载对象的，这里使用反射机制来获取
				PersonService.class.getClassLoader(),
				//接口，目标对象(UserService)实现的接口，也是反射获取的
				PersonService.class.getInterfaces(),
				//自己写的实现了 InvocationHandler 接口的实现类，在里面写代理类要完成的功能，
				new CustomInvocationHandler(new PersonService())
		);
		//打印看看现在拿到的对象是不是动态创建的代理对象
		System.out.println(personService.getClass());
		//执行这个代理对象的方法，他会执行代理类中的增强方法和被代理类中的add方法
		String name = personService.add("老六");
		System.out.println("执行结果:" + name);

	}
}
