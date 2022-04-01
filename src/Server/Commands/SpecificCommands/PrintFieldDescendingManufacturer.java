package Server.Commands.SpecificCommands;


import Server.Commands.Command;
import Server.Utilities.Logging;
import Server.Utilities.Receiver;

import java.io.Serializable;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.logging.Level;

public class PrintFieldDescendingManufacturer extends Command implements Serializable {
    private static final long serialVersionUID = 1234567L;

    @Override
    public void execute(Object o, DatagramChannel datagramChannel, SocketAddress socketAddress){
        Receiver receiver = new Receiver(datagramChannel);
        Logging.log( Level.INFO, "Server is executing print field descending order manufacturer command....");
        receiver.printFieldDescendingManufacturer((String) o, socketAddress);
    }
}
