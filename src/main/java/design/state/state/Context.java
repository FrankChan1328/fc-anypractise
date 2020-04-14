package design.state.state;

/**
 * 环境角色
 * <p> 持有一个状态类的引用；
 */
public class Context {
	private State state;
	
	public void sampleOperation() {
		state.sampleOperation();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
