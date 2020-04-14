package design.state.casestcp;

import design.state.casestcp.state.TcpClose;
import design.state.casestcp.state.TcpEstablished;
import design.state.casestcp.state.TcpListen;
import design.state.casestcp.state.TcpState;

public class Client {

	public static void main(String[] args) {
		TcpConnection conn = new TcpConnection();
		TcpState close = new TcpClose();
		TcpState established = new TcpEstablished();
		TcpState listen = new TcpListen();
		
		// 创建
		conn.setState(established);
		// 监听
		conn.setState(listen);
		// 关闭
		conn.setState(close);
	}

}
