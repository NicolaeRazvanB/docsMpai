package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientDataMapper {
    public static List<Client> readClients (String filename) throws IOException {
        List<Client> clientList=new ArrayList<>();
        BufferedReader bfr = new BufferedReader(new FileReader(filename));
        String line;
        while((line= bfr.readLine())!=null)
        {   String[] clientInfo=line.split(",");
            if (clientInfo.length == 3) {
            Client client = new Client(clientInfo[0], clientInfo[1], clientInfo[2]);
                clientList.add(client);
        } else {
            System.err.println("Invalid line: " + line);
        }
        }
        return clientList;
    }
    public static void saveClientsInFile(String filename, List<Client> clientList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Client client : clientList) {
                String line = client.getId() + "," + client.getNume() + "," + client.getEmail();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findClientById(String id) throws IOException {
        List<Client> comenzi = readClients("Clienti.txt");
        Optional<Client> client = comenzi.stream().filter(c -> c.getId().equals(id)).findFirst();
        if(client.isPresent()){
            System.out.println(client);
        } else {
            System.out.println("Clientul cu id-ul: " + client + " nu a fost gasit.");
        }
    }

    //if we had another param like a state, using email as replacement
    public void showClientsByStatus(String email) throws IOException {
        List<Client> clientList = readClients("Clienti.txt");
        List<Client> clientListByEmail = clientList.stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).toList();
        if(!clientListByEmail.isEmpty()){
            clientListByEmail.forEach(System.out::println);
        } else {
            System.out.println("Nu s-au gasit clienti cu emailul: " + email);
        }
    }
    public void updateClient(Client client) throws IOException {
        List<Client> clientList = readClients("Clienti.txt");
        if(!clientList.isEmpty()) {
            for(Client c : clientList) {
                if(c.getId().equals(client.getId())) {
                    c.setEmail(client.getEmail());
                    c.setNume(client.getNume());

                }
            }
            saveClientsInFile("Clienti.txt", clientList);
        } else {
            System.out.println("Nu s-a putut realiza modificarea client.");
        }
    }

    public void deleteClient(String id) throws IOException {
        List<Client> clientList = readClients("Clienti.txt");
        if(!clientList.isEmpty()) {
            clientList.removeIf(client -> client.getId().equals(id));
            saveClientsInFile("Clienti.txt", clientList);
        } else {
            System.out.println("Nu s-a putut realiza stergerea clientului.");
        }
    }

}
