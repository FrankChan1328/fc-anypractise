package design.state.casestcp.state;

/**
 * 具体的状态类
 */
public class TcpListen implements TcpState {

	@Override
	public void open() {
		System.out.println("tcp connection open...");
	}

	@Override
	public void close() {
		System.out.println("tcp connection close...");
	}

	@Override
	public void acknowledge() {
		System.out.println("tcp connection acknowledge...");
	}

}
