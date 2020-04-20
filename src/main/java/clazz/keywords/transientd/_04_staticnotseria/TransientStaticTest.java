package clazz.keywords.transientd._04_staticnotseria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientStaticTest {

    public static void main(String[] args) throws Exception {
        User2 user = new User2();
        User2.username = "Java技术栈1";
        user.setId("javastack");

        System.out.println("\n序列化之前");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e:/user.txt"));
        os.writeObject(user);
        os.flush();
        os.close();

        // 在反序列化出来之前，改变静态变量的值
        User2.username = "Java技术栈2";
        // 对于静态变量读取的不是序列化里的，而是JVM 中存储的
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("e:/user.txt"));
        user = (User2) is.readObject();
        is.close();
        
        System.out.println("\n序列化之后");
        System.out.println("username: " + user.getUsername());
        System.out.println("id: " + user.getId());
    }
}