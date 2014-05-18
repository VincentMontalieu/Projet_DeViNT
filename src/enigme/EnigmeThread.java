package enigme;

import devintAPI.Preferences;
import t2s.SIVOXDevint;

public class EnigmeThread extends Thread {

    private String cheminSon;
    protected SIVOXDevint voix;

    public EnigmeThread(String name, String cheminSon) {
        super(name);
        this.cheminSon = cheminSon;
        voix = Preferences.getData().getVoice();
    }

    public void run() {
        voix.stop();
        voix.playWav(cheminSon);
    }
}
