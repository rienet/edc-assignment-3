import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import swidgets.*;
import nz.sodium.*;

/** 
 * An example of how to use the GpsService class
 */
public class GpsGui {

    public static void main(String[] args){
        JFrame frame = new JFrame("GPS GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Initialise the GPS Service
        GpsService serv = new GpsService();
        // Retrieve Event Streams
        Stream<GpsEvent>[] streams = serv.getEventStreams();

        // Attach a handler method to each stream
        for(Stream<GpsEvent> s : streams){
            s.listen((GpsEvent ev) -> System.out.println(ev));
            
        }

        Cell<String> tracker0 = streams[0].map(u -> u.toString()).hold("");
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
        frame.add(label0);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(label8);
        frame.add(label9);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        
    }

} 
