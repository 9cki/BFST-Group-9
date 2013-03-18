import java.io.IOException;

import com.ximpleware.NavException;
import com.ximpleware.ParseException;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;

import graph.MyEdge;
import graph.MyGraph;
import gui.CreateGUI;

public class Driver {

	public static void main(String[] args) {
		try {
			MyGraph mg = new MyGraph();
			MyEdge[] edges = mg.getEdgeArray();
			new CreateGUI(edges);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
