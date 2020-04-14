package design.observer.type2;

public class Client {

    public static void main(String[] args) {
        // 创建主题对象
        ConcreteSubject subject = new ConcreteSubject();
        // 创建观察者对象
        Observer observer = new ConcreteObserver();
        // 登记观察者到主题上
        subject.attach(observer);
        // 改变主题对象状态
        subject.change("newState");
    }

}
