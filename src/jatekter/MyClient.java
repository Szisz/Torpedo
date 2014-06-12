/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatekter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author szilard
 */
public class MyClient extends Thread implements CommandClass {

    private Socket c_socket;
    DataInputStream input;
    private DataOutputStream output;
    private final String host;
    private final int port;
    private Console console;
    private int id;

    public MyClient(String _host, int _port) {
        this.host = _host;
        this.port = _port;
        this.id = -1;

        commands.add(new Pair<String, Class[]>("send", new Class[]{String.class}));
        commands.add(new Pair<String, Class[]>("sendClients", new Class[]{String.class, String.class}));
        //commands.add(new Pair<String, Class[]>("sendClientsInt", new Class[]{String.class, String.class}));
    }

    public int getID() {
        return id;
    }

    private void setID() throws IOException {
        while (id == -1) {
            String id_string = input.readUTF();
            Scanner sc = new Scanner(id_string);
            if (sc.next().equals("setID")) {
                this.id = sc.nextInt();
            }
        }
    }

    public void connect() throws IOException {
        c_socket = new Socket(host, port);
        if (c_socket.isConnected()) {
            System.out.println("Kliens csatlakozott a szerverhez!");
            input = new DataInputStream(c_socket.getInputStream());
            output = new DataOutputStream(c_socket.getOutputStream());
            send("Csatlakoztam:  " + c_socket);
            console = new Console(this);
            console.start();
        }

        this.setID();
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(input.readUTF());
            } catch (IOException ex) {
                Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void send(String msg) throws IOException {
        output.writeUTF(msg);
    }

    public void sendClients(String id, String msg) throws IOException {
        output.writeUTF("sendClients " + id + " " + msg);
    }
    
    /*public void sendClientsInt(String id, String msg) throws IOException{
        output.writeUTF("sendClientsInt "+ id +" "+ msg);
    }*/

    @Override
    public ArrayList<Pair<String, Class[]>> getCommands() {
        return commands;
    }
    
    public DataOutputStream getOutPut(){
        return output;
    }
}
