package Model.State;

import Model.Comanda;

public class ComandaPregatitaState implements IState{
    @Override
    public void doAction(Comanda comanda) {
        System.out.println("Comanda dvs a fost pregatita...");
        comanda.setStare(this);
        comanda.setStatus("Pregatita");
    }
}
