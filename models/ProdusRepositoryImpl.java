package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdusRepositoryImpl implements IProdusRepository{
    private static final String FILE_PATH = "Produse.txt";
    private List<Produs> listaProduse;

    public ProdusRepositoryImpl() {
        listaProduse = new ArrayList<>();
        // Load existing products from the file on initialization
        try {
            incarcaProduseDinFisier();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    private void incarcaProduseDinFisier() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String nume = parts[1];
                    float pret = Float.parseFloat(parts[2]);
                    listaProduse.add(new Produs(id, nume, pret));
                }
            }
        }
    }

    private void salveazaProduseInFisier() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Produs produs : listaProduse) {
                bw.write(produs.getId() + "," + produs.getNume() + "," + produs.getPret());
                bw.newLine();
            }
        }
    }

    @Override
    public void adaugaProdus(Produs produs) throws IOException {
        listaProduse.add(produs);
        salveazaProduseInFisier();
    }

    @Override
    public Optional<Produs> gasesteProdus(String id) throws IOException {
        return listaProduse.stream()
                .filter(produs -> produs.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Produs> listaProduse() throws IOException {
        return new ArrayList<>(listaProduse);
    }

    @Override
    public void stergeProdus(String id) throws IOException {
        listaProduse.removeIf(produs -> produs.getId().equals(id));
        salveazaProduseInFisier();
    }

    @Override
    public void actualizeazaProdus(String id, Produs produs) throws IOException {
        Optional<Produs> existingProdus = gasesteProdus(id);
        if (existingProdus.isPresent()) {
            Produs existing = existingProdus.get();
            existing.setNume(produs.getNume());
            existing.setPret(produs.getPret());
            salveazaProduseInFisier();
        } else {
            throw new IllegalArgumentException("Produsul cu ID-ul " + id + " nu exista.");
        }
    }
}
