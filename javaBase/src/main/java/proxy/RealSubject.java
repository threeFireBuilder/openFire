package proxy;

public class RealSubject implements Subject {

	@Override
	public void doSomething() {
		System.out.println("doSomething");

	}

	@Override
	public void doAnything() {
		System.out.println("doAnything");
		
	}

}
