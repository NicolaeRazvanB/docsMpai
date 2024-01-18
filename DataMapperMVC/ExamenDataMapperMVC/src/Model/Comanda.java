package Model;

import Model.State.IState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Comanda implements Serializable {
    private int idComanda;
    private List<Produs> listaProduse = new ArrayList<>();
    private Client client;
    private IState stare;
    private String status;

    public Comanda(int idComanda, List<Produs> listaProduse, Client client, String status) {
        this.idComanda = idComanda;
        this.listaProduse = listaProduse;
        this.client = client;
        this.stare = null;
        this.status = status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public List<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(List<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", listaProduse=" + listaProduse +
                ", client=" + client +
                '}';
    }

    public IState getStare() {
        return stare;
    }

    public void setStare(IState stare) {
        this.stare = stare;
    }

}
