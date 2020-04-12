package design.composite.safe;

/**
 * 抽象构件
 */
public interface Component {
	
	Composite getComposite();
	
	/**
	 * 具体的业务方法
	 */
	void sampleOperation();
}
