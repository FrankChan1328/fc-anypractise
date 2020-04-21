package clazz.implement.multi;

public class Animal implements CatBark, DogBark{

    @Override
    public void bark() {
        System.out.println("bark");
    }

    @Override
    public void attack() {
        System.out.println("attack");
    }
}
