import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

class PathFinding {
	Node start, end;

	PathFinding(Node start, Node end) {
		this.start = start;
		this.end = end;
	}

	public void BFS() {

		Queue<Node> findPath = new LinkedList<>();

		start.visited = true;
		end.visited = false;
		findPath.add(start);

		while (!findPath.isEmpty()) {
			Node instantNode = findPath.poll();

			for (Node node : instantNode.parents) {
				if (!node.visited) {
					findPath.add(node);
					node.visited = true;
					node.prev = instantNode;

					if (node == end) {
						findPath.clear();
						break;
					}
				}
			}
		}

		checkpoint(start, end);
		resetVisited();
	}

	private void checkpoint(Node start, Node end) {

		Node node = end;
		List<Node> shortestPath = new ArrayList<>();

		while (node != null && node != start.prev) {

			if (node.getName().equals("1009") || node.getName().equals("386") || node.getName().equals("45")|| node.getName().equals("41") || node.getName().equals("1044") || node.getName().equals("16")|| node.getName().equals("22") || node.getName().equals("76") || node.getName().equals("80") || node.getName().equals("426") || node.getName().equals("421") || node.getName().equals("527")|| node.getName().equals("881") || node.getName().equals("433")) {
				break;
			}

			node.increaseBetweennes(1);
			shortestPath.add(node);
			node = node.prev;

		}

		Collections.reverse(shortestPath);
		if (!shortestPath.isEmpty() && shortestPath.size() > 1) {
			
						
						
			for (int i = 1; i < shortestPath.size(); i++) {
				shortestPath.get(i).increaseCloseness(shortestPath.size());
			}
			
			

//			System.out.println(shortestPath);

		}

	}

	public void resetVisited() {
		for (int i = 1; i < Graph.nodes.size(); i++) {
			Graph.nodes.get(i).setVisited(false);
		}
	}

	public static void closenessDisplay(String name1, String name2) {
		double smallest = Graph.nodes.get(1).getCloseness();
		Node smallestNode = Graph.nodes.get(1);

		for (int i = 1; i < Graph.nodes.size(); i++) {
			if (Graph.nodes.get(i).getCloseness() > smallest ) {
				smallest = Graph.nodes.get(i).getCloseness();
				smallestNode = Graph.nodes.get(i);
			}
		}

		double closeness = 1 / smallest;
		
		System.out.println(name1 + Integer.valueOf(smallestNode.getName())/4 + name2 + String.format("%.7f", closeness));
	}

	public static void betwennesDisplay(String name1, String name2) {
		int biggest = Graph.nodes.get(1).getBetweennes();
		Node biggestNode = Graph.nodes.get(1);

		for (int i = 1; i < Graph.nodes.size(); i++) {
			if (Graph.nodes.get(i).getBetweennes() > biggest) {
				biggest = Graph.nodes.get(i).getBetweennes();
				biggestNode = Graph.nodes.get(i);
			}

		}
		
		System.out.println(name1 + biggestNode.getName() + name2 + biggest);
	}

}
