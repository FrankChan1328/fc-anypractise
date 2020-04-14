package design.bridge.bridge.abstraction;

import design.bridge.bridge.implementor.Implementor;

/**
 * 抽象化角色
 * <p> 给出定义，并持有一个对实现化对象的引用
 */
public abstract class Abstraction {
    protected Implementor impl;

    public void operation() {
        impl.operationImpl();
    }
}
