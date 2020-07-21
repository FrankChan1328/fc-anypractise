package design.builder.builder;

import design.builder.Product;

public class ConcreteBuilder extends Builder{
    private Product product = new Product();

    @Override
    public void buildPart1() {
      // build first part of product
    }
    @Override
    public void buildPart2() {
     // build second part of product
    }
    @Override
    public Product retriveResult() {
        return product;
    }
  }
