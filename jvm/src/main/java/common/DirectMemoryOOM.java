/**
 * 
 */
package common;



import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * vm args :-Xmx20M -XX:MaxDirectMemorySize=10M
 * 使用unsafe 分配本机内存
 * @author zy
 * 2017年5月8日
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024*1024;
	
	public static void main(String[] args) throws Exception{
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}

}