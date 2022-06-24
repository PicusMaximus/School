package OOAufgaben;

public class Radio {

    private String getOn() {
        if (isOn) {
            return "an";
        }
        return "aus";
    }

    private Boolean isOn = false;

    public int getVolume() {
        return volume;
    }

    public double getFrequency() {
        return frequency;
    }

    private int volume = 5;
    private double frequency = 99.9;

    public Radio(Boolean isOn, int volume, double frequency) {
        this.isOn = true;
        setVolume(volume);
        waehleSender(frequency);
        this.isOn = isOn;
    }

    public Radio() {
    }

    public boolean Power(){
        return isOn;
    }

    public boolean setVolume(int volume) {
        if (Power() && (volume >= 0 && volume <= 10)) {
            this.volume = volume;
            return true;
        }
        return false;
    }

    public void waehleSender(double frequency) {
        if (Power() && (frequency >= 85.0 && frequency <= 110.0)) {
            this.frequency = frequency;
        } else {
            this.frequency = 99.9;
        }
    }

    public String lauter() {
        if (Power()) {
            if (setVolume(this.volume + 1)) {
                return "Lauter, Lautstaerke ist jetzt " + volume;
            }
            return "Max ist erreicht";
        }
        return "Radio ist aus";

    }

    public String leiser() {
        if (Power()) {
            if (setVolume(this.volume - 1)) {
                return "Leiser, Lautstaerke ist jetzt " + volume;
            }
            return "Min ist erreicht";
        }
        return "Radio ist aus";
    }

    public void an() {
        if (isOn) {
            return;
        }
        this.isOn = true;
    }

    public void aus() {
        if (!isOn) {
            return;
        }
        this.isOn = false;
    }

    public String toString() {

        return String.format("Radio %s: Freq= %f, Laut =%d", getOn(), this.frequency, this.volume);
    }
}
