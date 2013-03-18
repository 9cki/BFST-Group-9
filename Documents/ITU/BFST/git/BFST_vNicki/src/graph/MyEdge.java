package graph;

public class MyEdge {
	private MyNode fromNode;
	private MyNode toNode;
	private double length;
	private int roadType;
	private String roadName;
	private int speedLimit;
	
	public MyEdge(MyNode f, MyNode t, double l, int rt, String rn, int sl) {
		fromNode = f;
		toNode = t;
		length = l;
		roadType = rt;
		roadName = rn;
		speedLimit = sl;
	}
	
	public MyNode getFromNode() {
		return fromNode;
	}
	public MyNode getToNode() {
		return toNode;
	}
	public double getLength() {
		return length;
	}
	public int getRoadType() {
		return roadType;
	}
	public String getRoadName() {
		return roadName;
	}
	public int getSpeedLimit() {
		return speedLimit;
	}
	
}
