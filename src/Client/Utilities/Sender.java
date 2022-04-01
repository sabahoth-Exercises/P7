package Client.Utilities;


import Client.Commands.SerializedCommands.SerializedArgumentCommand;
import Client.Commands.SerializedCommands.SerializedCombinedCommand;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Sender {
    private final DatagramSocket datagramSocket;
    private final Communicator communicator;

    public Sender(Communicator communicator) {
        this.communicator = communicator;
        this.datagramSocket = communicator.getDatagramSocket();
    }

    public DatagramSocket getDatagramSocket(){
        return datagramSocket;
    }

    public void sendObject(SerializedArgumentCommand sac) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(4096);
        ObjectOutputStream out = new ObjectOutputStream(byteStream);
        out.writeObject(sac);
        out.flush();
        byte[] dataBytes = byteStream.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(dataBytes, dataBytes.length, datagramSocket.getInetAddress(),
                communicator.getPort());
        datagramSocket.send(datagramPacket);
    }

    public void sendObject(SerializedCombinedCommand scc) throws IOException{
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(4096);
        ObjectOutputStream out = new ObjectOutputStream(byteStream);
        out.writeObject(scc);
        out.flush();
        byte[] dataBytes = byteStream.toByteArray();
        DatagramPacket datagramPacket = new DatagramPacket(dataBytes, dataBytes.length, datagramSocket.getInetAddress(),
                communicator.getPort());
        datagramSocket.send(datagramPacket);
    }
}