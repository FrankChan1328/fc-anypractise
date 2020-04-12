package design.composite.transparent;

import java.util.Enumeration;

/**
 * 树叶类
 * <p>add()/remove()/components() 这些方法并不适合树叶类
 */
public class Leaf implements Component{

	@Override
	public void sampleOperation() {
		
	}

	@Override
	public Composite getComposite() {
		return null;
	}

	@Override
	public void add(Component component) {
		
	}

	@Override
	public void remove(Component component) {
		
	}

	@Override
	public Enumeration components() {
		return null;
	}

}
