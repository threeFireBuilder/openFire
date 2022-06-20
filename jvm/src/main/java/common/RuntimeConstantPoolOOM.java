/**
 * 
 */
package common;

import java.util.ArrayList;
import java.util.*;

/**
 * 运行是常量导致内存溢出异常  方法区
 * vm args -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author zy
 * 2017��5��8��
 */
public class RuntimeConstantPoolOOM {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		int i = 0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}

}
