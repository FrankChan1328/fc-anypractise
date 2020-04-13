package design.command.command;

/**
 * 客户角色
 * <p> 创建了一个具体的命令 ConcreteCommand, 并指定了接收者
 * <p> 调用者Invoker 与操作者 Receiver 通过command 实现解耦
 *
 */
public class Client {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }

}
