package clazz.keywords.transientd._01_notseria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {

    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setUsername("Java技术栈");
        user.setId("javastack");

        System.out.println("\n序列化之前");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e:/user.txt"));
        os.writeObject(user);
        os.flush();
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("e:/user.txt"));
        user = (User) is.readObject();
        is.close();
        
        // ==> 被transient 修饰的变量不能被序列化
        System.out.println("\n序列化之后");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());
    }
}