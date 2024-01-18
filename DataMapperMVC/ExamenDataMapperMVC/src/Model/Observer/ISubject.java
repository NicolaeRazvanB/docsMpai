package Model.Observer;

import Model.Comanda;

public interface ISubject {
    public void trimiteNotificare(String mesaj, Comanda comanda);
    public void adaugaObserver(IObserver observer);
}
