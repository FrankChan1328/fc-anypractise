package clazz.keywords.transientd._02_seriaInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * id 被 transient 修改了，为什么还能序列化出来？
 * 那是因为 User3 实现了接口 Externalizable，而不是 Serializable。
 * 在 Java 中有两种实现序列化的方式，Serializable 和 Externalizable，
 * 可能大部分人只知道 Serializable 而不知道 Externalizable。
 * 这两种序列化方式的区别是：实现了 Serializable 接口是自动序列化的，
 * 实现 Externalizable 则需要手动序列化，通过 writeExternal 和 readExternal 方法手动进行，
 * 这也是为什么上面的 username 为 null 的原因了。
 *
 */
public class ExternalizableTest {

    public static void main(String[] args) throws Exception {

        User3 user = new User3();
        user.setUsername("Java技术栈");
        user.setId("javastack");
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File("javastack")));
        objectOutput.writeObject(user);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream(new File("javastack")));
        user = (User3) objectInput.readObject();

        System.out.println(user.getUsername());
        System.out.println(user.getId());

        objectOutput.close();
        objectInput.close();
    }

}
