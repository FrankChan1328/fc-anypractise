package design.prototype.cases.pandatoclone;

public class PandaToClone implements Cloneable {
    private int height, weight, age;

    public PandaToClone(int height, int weight) {
        super();
        this.age = 0;
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /****
     * 原始模式最重要的一个函数
     */
    public Object clone() {
        // 创建一个本类的对象，不能够返回给调用者
        PandaToClone temp = new PandaToClone(height, weight);
        temp.setAge(age);

        // 返回类型必须是Object
        return (Object) temp;
    }

    public String toString() {
        return "{weight:" + weight + ",height:" + height + ",age:" + age + "}";
    }

}
