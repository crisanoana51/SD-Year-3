package assignment3SD.restaurantApp.model;

public class ClientContainer implements Container<Client>{
    private final Client[] clients;
    public ClientContainer(Client[] clients){
        this.clients=clients;
    }
    @Override
    public Iterator<Client> getIterator(){
        return new ClientIterator();
    }

    private class ClientIterator implements Iterator<Client>{
        private int index;
        private ClientIterator(){
            this.index=0;
        }
        @Override
        public boolean hasNext(){
            return index < clients.length;
        }

        @Override
        public Client next(){
            if(hasNext()){
                return clients[index++];
            }
            return null;
        }
    }
}
