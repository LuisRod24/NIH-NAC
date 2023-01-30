package utility;

import org.apache.http.impl.conn.SystemDefaultRoutePlanner;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class JOptionPane extends JFrame {


    public String welcomePane () {
        JFrame parent = new JFrame();
        String longMac;
        String mac2;
        String mac;

        UIManager.put("OptionPane.minimumSize",new Dimension(500,500));

        String Mac_Addresses = javax.swing.JOptionPane.showInputDialog(parent,
                "Please enter Mac Address's", null);
        setResizable(false);
        setVisible(true);
        setSize(500, 400);
        longMac = Mac_Addresses.replaceAll("\\s", "").replaceAll("[^a-zA-Z0-9]+","");

        getContentPane().setLayout(null);
        closeIt();

       return longMac;
    }
    private void closeIt(){

        this.getContentPane().setVisible(false);
        this.dispose();

    }
}
