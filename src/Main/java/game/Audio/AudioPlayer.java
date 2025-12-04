package game.Audio;

import javax.sound.sampled.*;

public class AudioPlayer {
    private Clip clip;
    private FloatControl volumeControl;

    public AudioPlayer(String filePath) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(
                    getClass().getResource(filePath));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVolume(float decibels) {
        if (volumeControl != null) {
            volumeControl.setValue(decibels);
        }
    }


    public void playLoop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }
}
