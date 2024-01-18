package Model.State;

import Model.Comanda;
import Model.Observer.Subject;

public class ComandaOnorataState implements IState{
    private final Subject subject = new Subject();
    @Override
    public void doAction(Comanda comanda) {
        subject.adaugaObserver(comanda.getClient());
        System.out.println("Comanda a fost onorata...");
        comanda.setStare(this);
        comanda.setStatus("Onorata");
        //dupa ce ii schimb starea, vreau sa notific clientul
        subject.trimiteNotificare("Comanda a fost plasata!", comanda);
    }
}
