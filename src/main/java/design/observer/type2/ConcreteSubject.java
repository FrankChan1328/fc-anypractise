package design.observer.type2;

/**
 * 具体主题
 */
public class ConcreteSubject extends Subject{
    private String state;
    
    public void change(String newState){
        state = newState;
        this.notifyObservers();
    }
}
