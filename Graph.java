import java.util.ArrayList;

public class Graph {

	int size;

	Graph(int size) {
		this.size = size;
	}

	public static ArrayList<Node> nodes = new ArrayList<>();

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public int getSize() {
		return size;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void display() {

		for (int i = 0; i < nodes.size(); i++) {
			System.out.print(nodes.get(i) + " ");
			System.out.print(nodes.get(i).getParents());
			System.out.println();

		}
	}

}
