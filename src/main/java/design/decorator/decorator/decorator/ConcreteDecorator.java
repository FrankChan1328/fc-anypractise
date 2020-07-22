package design.decorator.decorator.decorator;

import design.decorator.decorator.component.Component;

public class ConcreteDecorator extends Decorator{
	public ConcreteDecorator(Component component) {
		super(component);
	}

	/**
	 * 委派给component
	 */
	@Override
	public void sampleOperation() {
		super.sampleOperation();
	}
}
