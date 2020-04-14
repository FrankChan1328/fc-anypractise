package design.observer.javautilobserver;

/**
 * 被观察者角色
 * <p>非java.util 的代码，继承Observable
 */
public class Watched extends Observable {
    private String data = "";

    public String retrieveDate() {
        return data;
    }

    /**
     * 改值
     */
    public void changeDate(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        this.notifyObservers();
    }
}
