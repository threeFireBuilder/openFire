package proxy;

import net.sf.cglib.proxy.Enhancer;

public class Factory {
	
	 /** 
     * �����ǿ֮���Ŀ���࣬������������߼�advice֮���Ŀ���� 
     *  
     * @param proxy 
     * @return 
     */
	public static Base getInstance(CglibProxy proxy){
		
		Enhancer e = new Enhancer();
		
		e.setSuperclass(Base.class);
		
		 //�ص������Ĳ���Ϊ���������CglibProxy�������ǿĿ������õ��Ǵ��������CglibProxy�е�intercept����  
        e.setCallback(proxy);  
        // �˿̣�base���ǵ�����Ŀ���࣬������ǿ����Ŀ����  
        Base base = (Base) e.create();  
		
		return base;
		
	}

}
