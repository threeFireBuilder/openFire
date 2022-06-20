package proxy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CglibProxy proxy = new CglibProxy();
		
		Base base = Factory.getInstance(proxy); 
		
		base.add();
	}

}
