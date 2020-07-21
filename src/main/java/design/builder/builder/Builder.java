package design.builder.builder;

import design.builder.Product;

public abstract class Builder {
    public abstract void buildPart1();

    public abstract void buildPart2();

    public abstract Product retriveResult();
}
