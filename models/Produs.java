package models;

public class Produs {
    String id;
    String nume;
    float pret;

    public Produs(String id, String nume, float pret) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id='" + id +
                ", nume='" + nume +
                ", pret=" + pret +
                '}';
    }
}
