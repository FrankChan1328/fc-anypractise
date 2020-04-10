package design.prototype.simple;

public class Client {
    private Prototype prototype;

    public void operation(Prototype example) {
        Prototype p = (Prototype) example.clone();
    }
    
    public static void main(String [] args){
        //
    }
}
