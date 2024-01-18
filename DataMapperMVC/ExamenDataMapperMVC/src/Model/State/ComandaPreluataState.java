package Model.State;

import Model.Comanda;

public class ComandaPreluataState implements IState{
    @Override
    public void doAction(Comanda comanda) {
        System.out.println("Comanda dvs a fost preluata...");
        comanda.setStare(this);
        comanda.setStatus("Preluata");

    }
}
