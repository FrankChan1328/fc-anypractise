package design.prototype.cases.pandatoclone;

public class Client {
    private static PandaToClone thisPanda, thatPanda;

    public static void main(String[] args) {
        thisPanda = new PandaToClone(100, 200);
        thisPanda.setAge(0);

        thatPanda = (PandaToClone) thisPanda.clone();
        System.out.println("this panda:" + thisPanda);
        System.out.println("that panda:" + thatPanda);
    }

}