package design.observer.type1;

public interface Subject {
    /**
     * 登记新的观察者对象
     */
    public void attach(Observer observer);

    /**
     * 删除观察者对象
     */
    public void detach(Observer observer);

    /**
     * 通知所有登记过的观察者对象
     */
    void notifyObservers();
}
