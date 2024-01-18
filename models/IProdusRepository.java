package models;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IProdusRepository {
    void adaugaProdus(Produs produs) throws IOException;
    Optional<Produs> gasesteProdus(String id) throws IOException;
    List<Produs> listaProduse() throws IOException;
    void stergeProdus(String id) throws IOException;
    void actualizeazaProdus(String id, Produs produs) throws IOException;
}
