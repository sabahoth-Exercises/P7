package Client.Commands.SpecificCommands;


import Client.Commands.Command;
import Client.Utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;

public class AddIfMin extends Command implements Serializable {
    private Receiver receiver;
    private static final long serialVersionUID = 1234567L;

    public AddIfMin(Receiver receiver){
        this.receiver = receiver;
    }

    public AddIfMin() {

    }


    @Override
    public void aboutCommand() {
        System.out.println("add_if_min {element} :            add a new item to the collection if its value is greater than the\"+\n" +
                "                \" value of the largest item in this collection");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Client: Invalid command's format! Fail to execute AddIfMin command!");
        } else {
            receiver.addIfMin();
        }
    }
}
