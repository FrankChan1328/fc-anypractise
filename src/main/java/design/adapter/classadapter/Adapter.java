package design.adapter.classadapter;

/**
 * 适配器(Adapter)角色：适配器把源接口转换成目标接口。
 * <p> 具体类 Adapter 把源Adaptee 适配到目标 Target上
 * <p> 适配器类 Adapter 是源的子类
 */
public class Adapter extends Adaptee implements Target {
    
    /** 
     * Class Adaptee doesn't contain operation sampleOperation2. 
     */
    public void sampleOperation2() {
        // Write your code here
    }
}