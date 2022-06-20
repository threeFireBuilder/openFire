/**
 * 
 */
package common;

/**
 * VM args -Xss128K
 * @author zy
 * 2017??5??8??
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;

	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("stack length :"+oom.stackLength);
			throw e;
		}
		

	}

}
