package Model.Observer;

import Model.Comanda;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
    private List<IObserver> observersList;

    public Subject() {
        this.observersList = new ArrayList<>();
    }

    @Override
    public void trimiteNotificare(String mesaj, Comanda comanda) {
        Subject subject = new Subject();
        subject.adaugaObserver(comanda.getClient());
        //notificarea se trimite doar clientului cu comanda respectiva, nu tuturor clientilor (lista cu observeri contine oricum un singur client, cel aferent comenzii)
        subject.observersList.get(0).receptioneazaMesaj(mesaj, comanda);
    }

    @Override
    public void adaugaObserver(IObserver observer) {
        observersList.add(observer);
    }
}
