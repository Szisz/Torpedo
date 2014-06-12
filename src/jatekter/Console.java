/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatekter;

import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author szilard
 */
public class Console extends Thread {

    private final CommandClass read;
    private final Scanner cScan;
    private String line;

    public Console(CommandClass _read) {
        this.read = _read;
        this.cScan = new Scanner(System.in);
    }

    public String getLine() {
        return line;
    }

    @Override
    public void run() {

        while (true) {
            line = cScan.nextLine();
            if (!"".equalsIgnoreCase(line)) {
                Scanner command_scan = new Scanner(line);
                String command = command_scan.next();
                for (int i = 0; i < read.getCommands().size(); i++) {
                    if (read.getCommands().get(i).getKey().equals(command)) {
                        try {
                            int args_num = read.getCommands().get(i).getValue().length;
                            Object[] args = new Object[args_num];
                            for (int j = 0; j < args_num; j++) {
                                args[j] = command_scan.next();
                            }
                            read.getClass().getMethod(command, read.getCommands().get(i).getValue()).invoke(read, args);
                        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchElementException ex) {
                            System.out.println("Nem megfelelo parameter(ek)!");
                        }
                    }
                }
            }
        }
    }
}
