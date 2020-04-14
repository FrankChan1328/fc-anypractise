package design.state.casestcp.state;

/**
 * 抽象状态角色
 *
 */
public interface TcpState {
	public void open();
	
	public void close();
	
	public void acknowledge();
}
