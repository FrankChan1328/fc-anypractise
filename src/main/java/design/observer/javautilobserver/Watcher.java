package design.observer.javautilobserver;

/**
 * 观察者角色
 * <p> 实现Observer 接口
 */
public class Watcher implements Observer {
    
    /**
     * 构造子
     */
    public Watcher(Watched w){
        w.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data has been chaged.now is :" + ((Watched) o).retrieveDate());
    }

}
