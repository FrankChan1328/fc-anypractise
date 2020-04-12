package design.composite.transparent;

import java.util.Enumeration;

/**
 * 抽象构件
 */
public interface Component {
	/**
	 * 具体的业务方法
	 */
	void sampleOperation();
	
	/**
	 * 返还自己的实例
	 */
	Composite getComposite();
	
	/**
	 * 聚集管理：增加子构件
	 */
	void add(Component component);
	
	/**
	 * 聚集管理：删除子构件
	 */
	void remove(Component component);
	
	Enumeration components();
}
