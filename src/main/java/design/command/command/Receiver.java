package design.command.command;

/**
 * 命令接收者，在命令的控制下执行行动方法
 */
public class Receiver {
    public Receiver() {
    }

    public void action() {
        System.out.println("action has been taken...");
    }
}