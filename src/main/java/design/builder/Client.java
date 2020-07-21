package design.builder;

import design.builder.builder.Builder;
import design.builder.builder.ConcreteBuilder;

public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
    }

}
