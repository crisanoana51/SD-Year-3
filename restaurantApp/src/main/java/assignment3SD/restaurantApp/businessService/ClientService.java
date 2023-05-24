package assignment3SD.restaurantApp.businessService;

import assignment3SD.restaurantApp.model.ClientContainer;
import assignment3SD.restaurantApp.model.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import assignment3SD.restaurantApp.model.Client;
import assignment3SD.restaurantApp.persistanceLayer.ClientRepo;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    private final ClientRepo clientRepo;

    public List<Client> readClient() {
        return clientRepo.findAll();
    }

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> findAllClients() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    public void deleteClient(int id) {
        clientRepo.deleteById(id);
    }

    public Client findClientById(int id) {
        ClientContainer clientContainer = new ClientContainer(readClient().toArray((Client[]::new)));
        Iterator<Client> iterator = clientContainer.getIterator();
        while (iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getId() == id)
                return client;
        }
        return null;
    }
}


