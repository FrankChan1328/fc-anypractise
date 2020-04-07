package clazz.staticinnerclazz;

public class Person {
	private String name;
	private Home home;

	public Person(String _name) {
		name = _name;
	}

	public void setHome(Home _home) {
		home = _home;
	}

	public static class Home {
		private String address;
		private String tel;

		public Home(String _address, String _tel) {
			address = _address;
			tel = _tel;
		}
	}

	public static void main(String[] args) {
		// 定义张三这个人
		Person p = new Person("张三");
		// 设置张三的家庭信息
		p.setHome(new Person.Home("上海", "021"));
	}
}
