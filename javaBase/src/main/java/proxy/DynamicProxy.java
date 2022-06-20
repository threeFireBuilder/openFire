package proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class DynamicProxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RealSubject real = new RealSubject();
		
		Subject s = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[] { Subject.class },
				new ProxyHandler(real));
		
		s.doSomething();
		System.out.println();
		s.doAnything();
		
		createProxyClassFile();
	}
	
	static void createProxyClassFile(){
		
		String name = "ProxySubject";
		
		byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
		
		try  
	    {   
	      FileOutputStream out = new FileOutputStream( name + ".class" );   
	      out.write( data );   
	      out.close();   
	    }   
	    catch( Exception e )   
	    {   
	      e.printStackTrace();   
	    }   
	}

}
