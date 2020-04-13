package design.command.casesaudioplayer.command;

import design.command.casesaudioplayer.AudioPlayer;

public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.rewind();
    }

}