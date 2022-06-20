/**
 * 
 */
package common;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * 检验 Unsafe类
 * @author zy
 */
public class TestUnSafe {

	
	public static void main(String[] args) throws Exception {
			
		Field f = Unsafe.class.getDeclaredField("theUnsafe");		
		f.setAccessible(true); 		
		
		Unsafe unsafe = (Unsafe) f.get(null);
		
/*
		 * Field
		 *public Object get(Object obj)
           throws IllegalArgumentException,
                  IllegalAccessException返回指定对象上此 Field 表示的字段的值。如果该值是一个基本类型值，则自动将其包装在一个对象中。
底层字段的值是按以下方式获得的：
如果底层字段是一个静态字段，则忽略 obj 变量；它可能为 null。
否则，底层字段是一个实例字段。如果指定的 obj 变量为 null，则该方法将抛出一个 NullPointerException。如果指定对象不是声明底层字段的类或接口的实例，则该方法将抛出一个 IllegalArgumentException。
如果此 Field 对象强制实施 Java 语言访问控制，并且底层字段是不可访问的，则该方法将抛出一个 IllegalAccessException。如果底层字段是静态的，并且声明该字段的类尚未初始化，则初始化这个类。
否则，从底层实例字段或静态字段中获取该值。如果该字段是一个基本类型字段，则在返回前将该值包装在一个对象中，否则照原样返回。
如果字段隐藏在 obj 的类型中，则根据前面的规则获得字段的值。
		 */
		
		
		Player p = (Player) unsafe.allocateInstance(Player.class);	
		System.out.println(p.getAge());
		p.setAge(555);
		System.out.println(p.getAge());
		
		String password = new String("l00k@myHor$e"); 
		String fake = new String(password.replaceAll(".", "?"));
		System.out.println(password);
		System.out.println(fake);
		
//		unsafe.getUnsafe().copyMemory(fake, 0L, null, unsafe.toAddress(password), unsafe.sizeOf(password));
	}

	class Player{
		
		private int age;
		
		public Player(){
			this.age = 50;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		
		
		
	}
}
