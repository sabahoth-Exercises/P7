package Client.Commands.SpecificCommands;


import Client.Commands.Command;
import Client.Utilities.Receiver;

import java.io.Serializable;

public class Exit extends Command implements Serializable {
    private final Receiver receiver;
    private static final long serialVersionUID = 1234567L;


    public Exit(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("exit                        - exit the program without saving to file");
    }

    @Override
    public void execute(String[] args) {
        if(args.length != 1) {
            System.out.println("Client: Invalid command's format! Fail to execute InfoCommand!");
        }
        else{
            receiver.exit();
        }
    }
}
