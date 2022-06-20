/**
 * 
 */
package common;

import java.util.*;



/**
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zy
 */
public class HeapOOM {
	
	static class OOMObejct{}

	public static void main(String args[]){
		List<OOMObejct> list = new ArrayList<OOMObejct>();
		
		while(true){
			list.add(new OOMObejct());
		}
	}

}
