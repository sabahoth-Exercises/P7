package Client.Commands.SpecificCommands;



import Client.Commands.Command;
import Client.Utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;

public class Clear extends Command implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private Receiver receiver;

    public Clear(Receiver receiver){
     this.receiver = receiver;
    }

    public Clear() {

    }

    @Override
    public void aboutCommand(){
        System.out.println("clear                            -clear collection");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute Info command");
        }
        else {
            receiver.clear();
        }
    }
}
