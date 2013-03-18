package gui;

import graph.MyEdge;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class CreateGUI {

	JFrame frame;
	
	public CreateGUI(MyEdge[] e){
		createFrame(e);
	}
	
	public void createFrame(MyEdge[] e){
		frame = new JFrame("AWESOME MAP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		Container contentPane = frame.getContentPane();
		
		
		JComponent dg = new DrawGraph(e);
		contentPane.add(dg);
		
		frame.pack();
		frame.setSize(new Dimension(960,760));
		frame.setVisible(true);
		
	}
}
