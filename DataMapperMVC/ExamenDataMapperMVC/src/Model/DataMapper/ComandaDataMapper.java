package Model.DataMapper;

import Model.Client;
import Model.Comanda;
import Model.Produs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ComandaDataMapper {
    public static List<Comanda> citesteComenziDinFisier(String numeFisier) {
        List<Comanda> listaComenzi = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;

            while ((linie = br.readLine()) != null) {
                int idComanda = Integer.parseInt(linie.trim());

                // Citire număr de produse
                linie = br.readLine();
                int numarProduse = Integer.parseInt(linie.trim());

                // Citire și descompunere detalii produse
                List<Produs> listaProduse = new ArrayList<>();
                for (int i = 0; i < numarProduse; i++) {
                    String detaliiProdus = br.readLine();
                    String[] infoProdus = detaliiProdus.split(",");
                    int idProdus = Integer.parseInt(infoProdus[0]);
                    String denumireProdus = infoProdus[1];
                    float pretProdus = Float.parseFloat(infoProdus[2]);
                    listaProduse.add(new Produs(idProdus, denumireProdus, pretProdus));
                }

                String[] infoClient = br.readLine().split(",");
                int idClient = Integer.parseInt(infoClient[0]);
                String numeClient = infoClient[1];
                int varstaClient = Integer.parseInt(infoClient[2]);
                Client client = new Client(idClient, numeClient, varstaClient);

                // Citire status
                String status = br.readLine().trim();

                // Adăugare comandă în listă
                Comanda comanda = new Comanda(idComanda, listaProduse, client, status);
                listaComenzi.add(comanda);

                // Linie goală între comenzi
                br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaComenzi;
    }


    public static void scrieComenziInFisier(String numeFisier, List<Comanda> listaComenzi) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(numeFisier))) {
            // Stergere continut vechi
            bw.write("");

            for (Comanda comanda : listaComenzi) {
                // Scriere idComanda
                bw.write(comanda.getIdComanda() + "\n");

                // Scriere număr de produse
                bw.write(comanda.getListaProduse().size() + "\n");

                // Scriere detalii produse
                for (Produs produs : comanda.getListaProduse()) {
                    bw.write(produs.getIdProdus() + "," + produs.getDenumireProdus() + "," + produs.getPretProdus() + "\n");
                }

                // Scriere detalii client
                Client client = comanda.getClient();
                bw.write(client.getIdClient() + "," + client.getNumeClient() + "," + client.getVarstaClient() + "\n");

                // Scriere status
                bw.write(comanda.getStatus() + "\n");

                // Linie goală între comenzi
                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afiseazaComandaDupaId(int idComanda) {
        List<Comanda> comenzi = citesteComenziDinFisier("comenzi.txt");
        Optional<Comanda> comanda = comenzi.stream().filter(c -> c.getIdComanda()==idComanda).findFirst();
        if(comanda.isPresent()){
            System.out.println(comanda);
        } else {
            System.out.println("Comanda cu id-ul: " + idComanda + " nu a fost gasita.");
        }
    }

    public void afiseazaComenziDupaStatus(String statusComanda) {
        List<Comanda> comenzi = citesteComenziDinFisier("comenzi.txt");
        List<Comanda> listaComenziFiltrate = comenzi.stream().filter(c -> c.getStatus().equalsIgnoreCase(statusComanda)).collect(Collectors.toList());
        if(!listaComenziFiltrate.isEmpty()){
            listaComenziFiltrate.forEach(System.out::println);
        } else {
            System.out.println("Nu s-au gasit comenzi cu statusul: " + statusComanda);
        }
    }

    public void modificaComanda(Comanda comanda) {
        List<Comanda> comenzi = citesteComenziDinFisier("comenzi.txt");
        if(comenzi.size() > 0) {
            for(Comanda c : comenzi) {
                if(c.getIdComanda() == comanda.getIdComanda()) {
                    c.setListaProduse(comanda.getListaProduse());
                    c.setClient(comanda.getClient());
                    c.setStare(comanda.getStare());
                    c.setStatus(comanda.getStatus());
                }
            }
            scrieComenziInFisier("comenzi.txt", comenzi);
        } else {
            System.out.println("Nu s-a putut realiza modificarea comenzii.");
        }
    }

    public void stergeComanda(int idComanda) {
        List<Comanda> comenzi = citesteComenziDinFisier("comenzi.txt");
        if(comenzi.size() > 0) {
            comenzi.removeIf(comanda -> comanda.getIdComanda()==idComanda);
            //pentru a reflecta schimbarea in fisier si a pastra datele actualizate dupa fiecare operatie
            scrieComenziInFisier("comenzi.txt", comenzi);
        } else {
            System.out.println("Nu s-a putut realiza stergerea comenzii.");
        }
    }
}
