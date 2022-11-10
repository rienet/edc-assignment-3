import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import swidgets.*;
import nz.sodium.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 
 * An example of how to use the GpsService class
 */
public class GpsGui {
    List<Cell<String>> trackers = new ArrayList<Cell<String>>();
    static List<JLabel> namesOfTrackers = new ArrayList<JLabel>();

    public static void main(String[] args){
        JFrame frame = new JFrame("GPS GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the panel to add labels
        JPanel panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,10));

        JPanel display0 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display6 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display7 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display8 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));
        JPanel display9 = new JPanel(new FlowLayout(FlowLayout.LEFT, 50, 0));

        // Initialise the GPS Service
        GpsService serv = new GpsService();
        // Retrieve Event Streams
        Stream<GpsEvent>[] streams = serv.getEventStreams();
        // Attach a handler method to each stream
        for(Stream<GpsEvent> s : streams){
            s.listen((GpsEvent ev) -> System.out.println(ev));
            
        }

        Cell<String> tracker0 = streams[0].map(u -> "lat: "+ u.latitude + "    long: " + u.longitude).hold("");
        Cell<String> tracker1 = streams[1].map(u -> u.toString()).hold("");
        Cell<String> tracker2 = streams[2].map(u -> u.toString()).hold("");
        Cell<String> tracker3 = streams[3].map(u -> u.toString()).hold("");
        Cell<String> tracker4 = streams[4].map(u -> u.toString()).hold("");
        Cell<String> tracker5 = streams[5].map(u -> u.toString()).hold("");
        Cell<String> tracker6 = streams[6].map(u -> u.toString()).hold("");
        Cell<String> tracker7 = streams[7].map(u -> u.toString()).hold("");
        Cell<String> tracker8 = streams[8].map(u -> u.toString()).hold("");
        Cell<String> tracker9 = streams[9].map(u -> u.toString()).hold("");
        SLabel label0 = new SLabel(tracker0);
        SLabel label1 = new SLabel(tracker1);
        SLabel label2 = new SLabel(tracker2);
        SLabel label3 = new SLabel(tracker3);
        SLabel label4 = new SLabel(tracker4);
        SLabel label5 = new SLabel(tracker5);
        SLabel label6 = new SLabel(tracker6);
        SLabel label7 = new SLabel(tracker7);
        SLabel label8 = new SLabel(tracker8);
        SLabel label9 = new SLabel(tracker9);

        // create name label for each tracker
        for(int i = 0; i<10; i++){
            namesOfTrackers.add(new JLabel("Tracker " + i));
        }
        display0.add(namesOfTrackers.get(0));
        display1.add(namesOfTrackers.get(1));
        display2.add(namesOfTrackers.get(2));
        display3.add(namesOfTrackers.get(3));
        display4.add(namesOfTrackers.get(4));
        display5.add(namesOfTrackers.get(5));
        display6.add(namesOfTrackers.get(6));
        display7.add(namesOfTrackers.get(7));
        display8.add(namesOfTrackers.get(8));
        display9.add(namesOfTrackers.get(9));

        // display streams for each tracker
        display0.add(label0);
        display1.add(label1);
        display2.add(label2);
        display3.add(label3);
        display4.add(label4);
        display5.add(label5);
        display6.add(label6);
        display7.add(label7);
        display8.add(label8);
        display9.add(label9);
        
        panel.add(display0);
        panel.add(Box.createVerticalGlue());
        panel.add(display1);
        panel.add(Box.createVerticalGlue());
        panel.add(display2);
        panel.add(Box.createVerticalGlue());
        panel.add(display3);
        panel.add(Box.createVerticalGlue());
        panel.add(display4);
        panel.add(Box.createVerticalGlue());
        panel.add(display5);
        panel.add(Box.createVerticalGlue());
        panel.add(display6);
        panel.add(Box.createVerticalGlue());
        panel.add(display7);
        panel.add(Box.createVerticalGlue());
        panel.add(display8);
        panel.add(Box.createVerticalGlue());
        panel.add(display9);
        panel.add(Box.createVerticalGlue());
        frame.add(panel);
        frame.setSize(700, 1000);
        frame.setVisible(true);

        
    }

} 
