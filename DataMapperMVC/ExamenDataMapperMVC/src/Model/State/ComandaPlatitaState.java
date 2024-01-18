package Model.State;

import Model.Comanda;

public class ComandaPlatitaState implements IState{
    @Override
    public void doAction(Comanda comanda) {
        System.out.println("Comanda a fost platita...");
        comanda.setStare(this);
        comanda.setStatus("Platita");
    }
}
