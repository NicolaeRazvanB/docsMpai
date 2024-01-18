package Model.State;

import Model.Comanda;

public interface IState {
    public void doAction(Comanda comanda);
}
