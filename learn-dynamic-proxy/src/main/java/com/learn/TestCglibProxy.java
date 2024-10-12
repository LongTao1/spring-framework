package com.learn;

import com.learn.cglib.DogService;

import java.lang.reflect.Method;

public class TestCglibProxy {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		//设置父类类型
		enhancer.setSuperclass(DogService.class);
		//配置代理类的方法拦截器
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				//实现增强代码的地方，这里就用一个简单的打印语句代替一下了
				System.out.println("Before method: " + method.getName());

				// 调用父类的方法
				Object result = proxy.invokeSuper(obj, args);

				//实现增强代码的地方，这里就用一个简单的打印语句代替一下了
				System.out.println("After method: " + method.getName());
				return result;
			}
		});

		//创建代理类
		DogService dogService = (DogService) enhancer.create();
		//调用代理类的方法
		dogService.sayHello();
	}
}
