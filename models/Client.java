package models;

public class Client {
    public String id;
    public String nume;
    public String email;

    public Client(String id, String nume, String email) {
        this.id = id;
        this.nume = nume;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id +
                ", nume='" + nume +
                ", email='" + email + '\'' +
                '}';
    }
}
