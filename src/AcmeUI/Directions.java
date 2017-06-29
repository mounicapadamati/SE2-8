package AcmeUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import AcmeUtility.GraphUtility;
import AcmeUtility.Vertex;

import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Directions extends JPanel {

	GraphUtility g = new GraphUtility();
	/**
	 * Create the panel.
	 */
	public Directions( JFrame f, LinkedList<Vertex> p) {
		setLayout(null);
		LinkedList<Vertex> path = new LinkedList<>(); 
		path =g.populateAndFind("1st avenue and A street", "1st avenue and E Street");
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 98, 383, 174);
		add(textArea);
		String dir = "";
		for (Vertex vertex : p) {
            System.out.println(vertex);
            dir += vertex.getName()+"\n";
            
        }
		System.out.println("directions from panel:"+dir);
		textArea.setText(dir);
		
		JLabel lblNewLabel = new JLabel("The Directions");
		lblNewLabel.setBounds(151, 35, 46, 14);
		add(lblNewLabel);

	}
}
