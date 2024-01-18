package Model;

import java.io.Serializable;

public class Produs implements Serializable {
    private int idProdus;
    private String denumireProdus;
    private Float pretProdus;

    public Produs(int idProdus, String denumireProdus, Float pretProdus) {
        this.idProdus = idProdus;
        this.denumireProdus = denumireProdus;
        this.pretProdus = pretProdus;
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public Float getPretProdus() {
        return pretProdus;
    }

    public void setPretProdus(Float pretProdus) {
        this.pretProdus = pretProdus;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "idProdus=" + idProdus +
                ", denumireProdus='" + denumireProdus + '\'' +
                ", pretProdus=" + pretProdus +
                '}';
    }
}
