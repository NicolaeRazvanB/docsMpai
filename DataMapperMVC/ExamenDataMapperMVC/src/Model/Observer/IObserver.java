package Model.Observer;

import Model.Comanda;

public interface IObserver {
    public void receptioneazaMesaj(String mesaj, Comanda comanda);
}
