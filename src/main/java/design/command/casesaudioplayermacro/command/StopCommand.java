package design.command.casesaudioplayermacro.command;

import design.command.casesaudioplayermacro.AudioPlayer;

public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.stop();
    }
}
