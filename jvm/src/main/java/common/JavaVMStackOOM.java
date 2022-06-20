package common;

/**
 *  * vm args :-Xss2M  虚拟机栈内存
 *  * 多线程造成导致内存溢出异常（）
 * @author zy
 */

public class JavaVMStackOOM {

	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		
		// TODO Auto-generated method stub
				while(true){
					Thread thread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							
							dontStop();
						}
					});
					thread.start();
				}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
