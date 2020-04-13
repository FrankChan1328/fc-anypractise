package design.command.casesaudioplayer.command;

import design.command.casesaudioplayer.AudioPlayer;

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
