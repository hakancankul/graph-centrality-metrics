import java.util.*;

class Node {
	int betweennes;
	int closeness;
	String name;
	ArrayList<Node> parents;
	boolean visited = false;
	Node prev = null;

	Node(String name) {
		this.name = name;
		this.parents = new ArrayList<>();
	}

	void addParent(Node node) {
		this.parents.add(node);
		node.parents.add(this);
		this.betweennes = 0;
		this.closeness = 0;
	}

	public int getBetweennes() {
		return betweennes;
	}

	public void increaseBetweennes(int betweennes) {
		this.betweennes += 1;
	}

	public String toString() {
		return this.name;
	}

	public int getCloseness() {
		return closeness;
	}

	public void increaseCloseness(int closeness) {
		this.closeness += closeness;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Node> getParents() {
		return parents;
	}

	public void setParents(ArrayList<Node> neighbors) {
		this.parents = neighbors;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}