
package com.pocan.portscanner;

import static com.pocan.portscanner.PortScanner.ANSI_CYAN_BACKGROUND;
import static com.pocan.portscanner.PortScanner.TEXT_RED;
import static com.pocan.portscanner.PortScanner.TEXT_YELLOW;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Pocan
 */
public class Main extends FileModule{
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    public static void main(String[] args) {
        System.out.println("PortScanner 1.0 by Pocan");
        System.out.println("Join my discord server https://discord.gg/D4bqSty ");
     
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);
        System.out.println("Please write ip address." + TEXT_RESET);
        String ipAddress = scan.nextLine();    
        System.out.println("Please write start port." + TEXT_RESET);
        int startPort = scan.nextInt();    
        System.out.println("Please write end port." + TEXT_RESET);
        int endPort = scan.nextInt();   
        System.out.println("Please write check second (Example: 1 (1/1000 seconds))." + TEXT_RESET);
        int checkTime = scan.nextInt();  
        PortScanner portScanner = new PortScanner(ipAddress, startPort, endPort, checkTime);
        //System.out.println(ipAddress + startPort + endPort + checkTime);
        ArrayList<String> arr = portScanner.scanPorts(ipAddress, startPort, endPort, checkTime);
        
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");  
        String strDate = dateFormat.format(date);  
        
        FileModule fileModule = new FileModule();
        fileModule.createFolder();
        fileModule.createFile("scan-" + ipAddress);
        fileModule.writeFile("scan-" + ipAddress, arr);
        System.out.println("scan-" + ipAddress);
    }
           
    
}
