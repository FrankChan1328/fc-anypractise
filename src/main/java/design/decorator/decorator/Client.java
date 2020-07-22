package design.decorator.decorator;

import design.decorator.decorator.component.Component;
import design.decorator.decorator.component.ConcreteComponent;
import design.decorator.decorator.decorator.Decorator;

public class Client {
	public static void main(String[] args) {
		Component decorator = new Decorator(new ConcreteComponent());
		decorator.sampleOperation();
	}
}
