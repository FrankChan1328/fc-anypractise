package clazz.implement.multiabstract;

public class Animal extends CatBark implements DogBark{

    @Override
    public void bark() {
        System.out.println("bark");
    }

    /**
     * 该部分既实现了DogBark 的 attack 方法也覆盖了CatBark 的 attack 方法
     */
    @Override
    public void attack() {
        System.out.println("animal attack");
    }
}
