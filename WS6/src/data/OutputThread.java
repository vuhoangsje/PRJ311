/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author vuhoa
 */
public class OutputThread extends Thread{
    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String sender;
    String receiver;

    public OutputThread(Socket socket, JTextArea txt, String sender, String receiver) {
        super();
        this.socket = socket;
        this.txt = txt;
        this.sender = sender;
        this.receiver = receiver;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Network Error");
            System.exit(0);
        } 
    }
    public void run(){
        while (true) {            
            try {
                if (socket != null){
                    String msg = "";
                    if ((msg = bf.readLine()) != null && msg.length() >0){
                        txt.append("\n" + receiver + ":" + msg);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
    
}
