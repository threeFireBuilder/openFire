package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{

	private Object proxied;
	
	public ProxyHandler(Object proxied){
		this.proxied = proxied;
	}	
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before->>>>>>>");
		
		Object o = method.invoke(proxied, args);
		System.out.println("after->>>>>>>");

		return o;
	}

}
