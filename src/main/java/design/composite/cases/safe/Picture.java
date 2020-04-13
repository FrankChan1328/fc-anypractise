package design.composite.cases.safe;

import java.util.Vector;

/**
 * 树枝构件
 * <p>
 * 实现抽象构件所要求的方法，并且还额外提供了用于管理子对象聚集的一系列方法
 *
 */
public class Picture extends Graphics {

	private Vector list = new Vector(10);

	@Override
	public void draw() {
		for (int i = 0; i < list.size(); i++) {
			Graphics g = (Graphics) list.get(i);
			g.draw();
		}
	}

	public void add(Graphics g) {
		list.add(g);
	}

	public void remove(Graphics g) {
		list.remove(g);
	}

	public Graphics getChild(int i) {
		return (Graphics) list.get(i);
	}

}
