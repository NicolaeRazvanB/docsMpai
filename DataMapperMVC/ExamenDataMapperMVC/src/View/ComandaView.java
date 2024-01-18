package View;

import Model.Comanda;
import Model.DataMapper.ComandaDataMapper;

import java.util.List;

public class ComandaView {
    private static final String NUME_FISIER = "comenzi.txt";
    public void afiseazaComenzi() {
        List<Comanda> comenziFisier = ComandaDataMapper.citesteComenziDinFisier(NUME_FISIER);
        if(comenziFisier.size()>0) {
            for(Comanda comanda : comenziFisier) {
                System.out.println(comanda);
            }
        } else {
            System.out.println("Nu exista inca comenzi inregistrare pentru magazin.");
        }
    }

    public void afiseazaComanda(int idComanda) {
        ComandaDataMapper comandaDataMapper = new ComandaDataMapper();
        comandaDataMapper.afiseazaComandaDupaId(idComanda);
    }

    public void afiseazaComenziDupaStatus(String status) {
        ComandaDataMapper comandaDataMapper = new ComandaDataMapper();
        comandaDataMapper.afiseazaComenziDupaStatus(status);
    }

    public void modificaComanda(Comanda comanda) {
        ComandaDataMapper comandaDataMapper = new ComandaDataMapper();
        comandaDataMapper.modificaComanda(comanda);
    }

    public void stergeComanda(int idComanda) {
        ComandaDataMapper comandaDataMapper = new ComandaDataMapper();
        comandaDataMapper.stergeComanda(idComanda);
    }


}
