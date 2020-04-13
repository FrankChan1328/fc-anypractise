package design.command.casesaudioplayer;

import design.command.casesaudioplayer.command.Command;
import design.command.casesaudioplayer.command.PlayCommand;
import design.command.casesaudioplayer.command.RewindCommand;
import design.command.casesaudioplayer.command.StopCommand;

public class Julia {
    public static void main(String[] args) {
        // 创建接收者对象
        AudioPlayer audioPlayer = new AudioPlayer();
        // 创建命令对象
        Command playCommand = new PlayCommand(audioPlayer);
        Command rewindCommand = new RewindCommand(audioPlayer);
        Command stopCommand = new StopCommand(audioPlayer);
        // 创建请求者对象
        Keypad keypad = new Keypad();
        keypad.setPlayCommand(playCommand);
        keypad.setRewindCommand(rewindCommand);
        keypad.setStopCommand(stopCommand);
        // 测试
        keypad.play();
        keypad.rewind();
        keypad.stop();
        keypad.play();
        keypad.stop();
    }
}
