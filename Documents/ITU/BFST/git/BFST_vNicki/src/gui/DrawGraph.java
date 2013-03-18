package gui;
import graph.MyEdge;
import graph.MyGraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.swing.*;

public class DrawGraph extends JComponent {
	MyEdge[] edges;
	int upperLeftX = 434168;
	int upperLeftY = 6412239;
	

	public DrawGraph(MyEdge[] e){
		edges = e;

		setPreferredSize(new Dimension(960, 760));
	}

	public void paintComponent(Graphics g) {
		try {
			for(MyEdge e : edges){
				int roadType = e.getRoadType();
				if(roadType == 1)
					g.setColor(Color.RED);
				else if(roadType == 3)
					g.setColor(Color.BLUE);
				else if(roadType == 8)
					g.setColor(Color.GREEN);
				else
					g.setColor(Color.BLACK);
					
				int fromX = (int) (-(upperLeftX - e.getFromNode().getX()) / 500);
				int fromY = (int) (upperLeftY - e.getFromNode().getY()) / 500;
				int toX = (int) (-(upperLeftX - e.getToNode().getX()) / 500);
				int toY = (int) (upperLeftY - e.getToNode().getY()) / 500;
				g.drawLine(fromX, fromY, toX, toY);
				//System.out.println(e.getFromNode().getX() + " " + e.getFromNode().getY() + " " + e.getToNode().getX() + " " + e.getToNode().getY());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void drawNodes(){

	}

	public void drawEdges(){


	}

}