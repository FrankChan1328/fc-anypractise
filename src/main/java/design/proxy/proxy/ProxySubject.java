package design.proxy.proxy;

public class ProxySubject extends Subject {
	private RealSubject realSubject;

	public ProxySubject() {
	}

	// 实现请求方法
	public void request() {
		preRequest();
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		realSubject.request();
		postRequest();
	}

	// 请求前的操作
	private void preRequest() {
		// sth you want to do before requesting
	}

	// 请求后的操作
	private void postRequest() {
		// sth you want to do after requesting
	}
}
