package Server;


import Server.Database.DatabaseCommunicator;
import Server.Database.ProductBase;
import Server.Utilities.CollectionManager;
import Server.Utilities.Logging;
import Server.Utilities.ServerController;

import java.sql.SQLException;
import java.util.logging.Level;

public class Server {
    public static void main(String[] args) {
        try {
            String port = args[0];
            Logging.log( Level.WARNING, "Port must be int number! Please notice about it!");
            DatabaseCommunicator databaseCommunicator = new DatabaseCommunicator();
            databaseCommunicator.start();
            CollectionManager.initializeCollection();
            ProductBase.loadCollection(CollectionManager.getCollection());
            ServerController serverController = new ServerController(port);
            serverController.run();
        } catch(ArrayIndexOutOfBoundsException e){
            Logging.log(Level.INFO, "Invalid port!");
        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        }
    }
}
