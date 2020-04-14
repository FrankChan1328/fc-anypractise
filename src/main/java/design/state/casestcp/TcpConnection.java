package design.state.casestcp;

import design.state.casestcp.state.TcpState;

/**
 * 环境角色
 *
 */
public class TcpConnection {
	private TcpState state;
	
	public TcpState getState() {
		return state;
	}
	
	public void setState(TcpState state) {
		this.state = state;
	}

	public void open() {
		state.open();
	}
	
	public void close() {
		state.close();
	}
	
	public void acknowledge() {
		state.acknowledge();
	}
}
