package graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.ximpleware.NavException;
import com.ximpleware.ParseException;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;


public class MyGraph {

	private static MyNode[] nodes;
	private static MyEdge[] edges;
	private static int edgeCount = 0;

	public MyGraph() throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		initNodes();
		initEdges();
	}
	
	/*public static void main(String[] args) throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		//initializes the nodes and the edges
		initNodes();
		initEdges();
		//counts the nodes
		int nodeCount = 0;
		for(MyNode n : nodes) {
			if(n != null) {
				nodeCount++;
			}
		}

		//prints out the number of nodes, number of edges and all edges with known nodes.
		System.out.println("Number of nodes: " +nodeCount);
		System.out.println("Number of edges: " +edgeCount);
		for(MyEdge e : edges) {
			if(e != null) {
				System.out.println(e.getFromNode().getKDV() + " " + e.getToNode().getKDV() + " " + e.getLength() + " " + e.getRoadType() + " " + e.getRoadName() + " " + e.getSpeedLimit());

			}
		}
	}*/

	//Initializes the nodes in an array
	public static void initNodes() throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		String[] nodeArray = createNodeArray();
		nodes = new MyNode[nodeArray.length];
		int i = 0;
		while(i < nodeArray.length) {
			if(nodeArray[i] != null) {
				String[] lineArray = nodeArray[i].split("\\s&&&\\s");
				//Creates a new MyNode for each line in the nodeArray.
				nodes[i] = new MyNode(Integer.parseInt(lineArray[0]), Double.parseDouble(lineArray[1]), Double.parseDouble(lineArray[2]));
			}
			i++;
		}
	}

	//Initializes the edges in an array
	public static void initEdges() throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		String[] edgeArray = createEdgeArray();
		edges = new MyEdge[edgeArray.length];
		String[] lineArray;
		for(int i = 0; i < edgeArray.length; i++) {
			if(edgeArray[i] != null) {
				edgeCount++;
				String s = edgeArray[i];
				lineArray = s.split("\\s&&&\\s");
				//The MyEdge object needs a from node and a to node. They are initialized here
				/*for(MyNode n : nodes) {
					if(n != null) {
						if(n.getKDV() == Integer.parseInt(lineArray[0])) {
							fNode = n;
						}
						if(n.getKDV() == Integer.parseInt(lineArray[1])) {
							tNode = n;
						}
					}
				}*/
				edges[i] = new MyEdge(nodes[Integer.parseInt(lineArray[0])-1], nodes[Integer.parseInt(lineArray[1])-1], Double.parseDouble(lineArray[2]), Integer.parseInt(lineArray[3]), lineArray[4], Integer.parseInt(lineArray[5]));
			}
		}
	}

	//Creates the node array by parsing the xml file
	public static String[] createNodeArray() throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		MyNodeVTD nodeVTD = new MyNodeVTD();
		String[] nodeArray = null;
		try {
			nodeArray = nodeVTD.parse("kdv_node_unload.xml"); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodeArray;
	}

	//Creates the edge array by parsing the xml file
	public static String[] createEdgeArray() throws NavException, XPathParseException, XPathEvalException, ParseException, IOException {
		MyEdgeVTD edgeVTD = new MyEdgeVTD();
		String[] edgeArray = null;
		try {
			edgeArray = edgeVTD.parse("kdv_unload.xml"); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		return edgeArray;
	}
	
	public MyEdge[] getEdgeArray(){
		return edges;
	}



}
