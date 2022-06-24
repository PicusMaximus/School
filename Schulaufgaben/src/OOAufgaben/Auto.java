package OOAufgaben;

public class Auto {
    String Kennzeichen;
    Double Kilometerstand;
    Double Tankvolumen;
    Double Kraftstoffverbrauch;
    Double Kraftstoffmenge;

    public Auto(String kennzeichen, Double kilometerstand, Double tankvolumen, Double kraftstoffverbrauch, Double kraftstoffmenge) {
        Kennzeichen = kennzeichen;
        Kilometerstand = kilometerstand;
        Tankvolumen = tankvolumen;
        Kraftstoffverbrauch = kraftstoffverbrauch;
        Kraftstoffmenge = kraftstoffmenge;
    }

    public Auto() {

    }

    public String getKennzeichen() {
        return Kennzeichen;
    }

    public Double getKilometerstand() {
        return Kilometerstand;
    }

    public Double getTankvolumen() {
        return Tankvolumen;
    }

    public double tanken(double amount){

        if(this.Kraftstoffmenge + amount <= Tankvolumen){
            this.Kraftstoffmenge += amount;
        }else {
            this.Kraftstoffmenge = Tankvolumen;
        }
        return Kraftstoffmenge;
    }

    public Double getKraftstoffmenge() {
        return Kraftstoffmenge;
    }

    public String fahren(double strecke){
        double verbrauch = Kraftstoffverbrauch * strecke/100;
        if(verbrauch <= Tankvolumen){
            this.Kilometerstand += strecke;
            return  Kilometerstand.toString();
        }
        return "Tankfuellung nicht ausreichend";
    }
}
