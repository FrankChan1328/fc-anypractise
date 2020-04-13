package design.command.command;

/**
 * 请求者
 * <p> 接收command 作为构造函数参数
 *
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 行动方法
     */
    public void action() {
        command.execute();
    }
}
