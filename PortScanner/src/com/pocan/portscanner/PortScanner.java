
package com.pocan.portscanner;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Pocan
 */
public class PortScanner{
    private String ipAddress;
    private int startPort,endPort,checkTime;
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";
    
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public PortScanner(String ipAddress, int startPort, int endPort, int checkTime) {
        this.ipAddress = ipAddress;
        this.startPort = startPort;
        this.endPort = endPort;
        this.checkTime = checkTime;
    }
    
    public ArrayList<String> scanPorts(String ipAddress, int startPort, int endPort, int checkTime) {
        ArrayList<String> ports = new ArrayList<String>();
        ports.add("JOIN MY DISCORD SERVER https://discord.gg/D4bqSty");
        ports.add("TARGET IP -> " + ipAddress);
        for (int port = startPort; port <= endPort; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(ipAddress, port), checkTime);
                socket.close();
                System.out.println("Port -> " + port + " open");
                ports.add("Port -> " + port + " open");
            } catch (Exception ex) {

            }
        }
        return ports;
    }

 



}
