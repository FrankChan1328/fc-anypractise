package kwords.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo {

    public static void main(String[] args) throws Exception {
        method1();
    }

    public static void method1() throws Exception {

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
//        oos.writeObject(new Person("lisi", 20, "kr"));

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
        Person p = (Person) ois.readObject();
        p.show();
//        oos.close();
        ois.close();
    }
}

class Person implements Serializable {

    // public static final long serialVersionUID=42L;
    String name;
    int age;
    static String country = "cn";

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public void show() {
        System.out.println("name:" + name + "...age:" + age + "...county:" + country);
    }
}