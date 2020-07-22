package design.decorator.decorator.decorator;

import design.decorator.decorator.component.Component;

/**
 * 装饰类
 * <li>装饰类里有私有属性 component
 * <li>装饰类实现了构件接口 Component
 * <li>每一个实现方法都委派给父类，但又不是单纯的委派，而是功能的增强
 */
public class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	/**
	 * 委派给component
	 */
	@Override
	public void sampleOperation() {
		component.sampleOperation();
	}
}