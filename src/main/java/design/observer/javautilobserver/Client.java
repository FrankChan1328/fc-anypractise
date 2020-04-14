package design.observer.javautilobserver;

public class Client {

    public static void main(String[] args) {
        // 创建被观察者
        Watched watched = new Watched();
        // 创建观察者并登记
        Observer watcher = new Watcher(watched);
        // 给被观察者赋值
        watched.changeDate("test");
        watched.changeDate("test1");
        watched.changeDate("test1");
        watched.changeDate("test2");
    }

}
