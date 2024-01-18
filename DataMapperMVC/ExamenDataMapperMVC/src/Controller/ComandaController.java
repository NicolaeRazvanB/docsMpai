package Controller;

import Model.Client;
import Model.Comanda;
import Model.Produs;
import View.ComandaView;

import java.util.List;

public class ComandaController {
    private Comanda model;
    private ComandaView view;

    public ComandaController(Comanda model, ComandaView view) {
        this.model = model;
        this.view = view;
    }

    //getteri si setteri, metode din clasa Comanda
    public String getStatus() {
        return model.getStatus();
    }

    public void setStatus(String status) {
        model.setStatus(status);
    }

    public int getIdComanda() {
        return model.getIdComanda();
    }

    public void setIdComanda(int idComanda) {
        setIdComanda(idComanda);
    }

    public List<Produs> getListaProduse() {
        return model.getListaProduse();
    }

    public void setListaProduse(List<Produs> listaProduse) {
        model.setListaProduse(listaProduse);
    }

    public Client getClient() {
        return model.getClient();
    }

    public void setClient(Client client) {
        model.setClient(client);
    }

    //metode din clasa ComandaView care se ocupa cu afisari
    public void afiseazaComenzi() {
        view.afiseazaComenzi();
    }

    public void afiseazaComanda(int idComanda) {
        view.afiseazaComanda(idComanda);
    }

    public void modificaComanda(Comanda comanda) {
        view.modificaComanda(comanda);
    }

    public void stergeComanda(int idComanda) {
        view.stergeComanda(idComanda);
    }

    public void afiseazaComenziDupaStatus(String status) {
        view.afiseazaComenziDupaStatus(status);
    }

}