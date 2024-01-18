package Model;

import Model.Observer.IObserver;

import java.io.Serializable;

public class Client implements Serializable, IObserver {
    private int idClient;
    private String numeClient;
    private int varstaClient;

    public Client(int idClient, String numeClient, int varstaClient) {
        this.idClient = idClient;
        this.numeClient = numeClient;
        this.varstaClient = varstaClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public int getVarstaClient() {
        return varstaClient;
    }

    public void setVarstaClient(int varstaClient) {
        this.varstaClient = varstaClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", numeClient='" + numeClient + '\'' +
                ", varstaClient=" + varstaClient +
                '}';
    }

    @Override
    public void receptioneazaMesaj(String mesaj, Comanda comanda) {
        System.out.println(this.numeClient + " , ai primit mesajul: " + mesaj + " pentru comanda cu id-ul: " + comanda.getIdComanda());
    }
}
