package graph;

public class MyNode {
	private int kdv;
	private double xcoord;
	private double ycoord;
	
	public MyNode(int kdv, double x, double y) {
		this.kdv = kdv;
		xcoord = x;
		ycoord = y;
	}
	
	public int getKDV() {
		return kdv;
	}
	
	public double getX() {
		return xcoord;
	}
	
	public double getY() {
		return ycoord;
	}
}
