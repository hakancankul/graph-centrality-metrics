import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class main {
	public static void main(String[] args) throws IOException {

		Graph karateClub = new Graph(35);

		for (int i = 0; i < karateClub.getSize(); i++) {
			String number = String.valueOf(i);
			Node node = new Node(number);
			karateClub.addNode(node);
		}

		String fileName = "karate_club_network.txt";
		FileReader fileReader = new FileReader(fileName);
		String line;

		BufferedReader br = new BufferedReader(fileReader);
		while ((line = br.readLine()) != null) {

			String[] parts = line.split(" ");
			int s = Integer.valueOf(parts[0]);
			int d = Integer.valueOf(parts[1]);

			Node source = karateClub.getNodes().get(s);
			Node destination = karateClub.getNodes().get(d);

			source.addParent(destination);

			karateClub.getNodes().set(s, source);
			karateClub.getNodes().set(d, destination);

		}
		br.close();

		for (int i = 1; i <= 33; i++) {
			for (int j = i + 1; j <= 34; j++) {

				new PathFinding(karateClub.getNodes().get(i), karateClub.getNodes().get(j)).BFS();

			}
		}

		System.out.println("Ramazan Hakan CANKUL - 2017510021");
		String str1 = "Zachary Karate Club Network – The Highest Node for Betweenness is ";
		String str2 = " and the value is ";
		String str3 = "Zachary Karate Club Network – The Highest Node for Closeness is ";

		PathFinding.betwennesDisplay(str1, str2);
		PathFinding.closenessDisplay(str3, str2);
		System.out.println("Wait for Facebook Social Network(Average 50-60sec)");

		Graph facebookNetwork = new Graph(1519);

		for (int i = 0; i < facebookNetwork.getSize(); i++) {
			String number = String.valueOf(i);
			Node node = new Node(number);
			facebookNetwork.addNode(node);
		}

		String fileName2 = "facebook_social_network.txt";
		FileReader fileReader2 = new FileReader(fileName2);
		String line2;

		BufferedReader br2 = new BufferedReader(fileReader2);
		while ((line2 = br2.readLine()) != null) {

			String[] parts = line2.split(" ");
			int s = Integer.valueOf(parts[0]);
			int d = Integer.valueOf(parts[1]);
			Node source = facebookNetwork.getNodes().get(s);
			Node destination = facebookNetwork.getNodes().get(d);

			source.addParent(destination);

			facebookNetwork.getNodes().set(s, source);
			facebookNetwork.getNodes().set(d, destination);

		}
		br2.close();

		for (int i = 1; i <= 1518; i++) {
			for (int j = i + 1; j <= 1517; j++) {

				new PathFinding(facebookNetwork.getNodes().get(i), facebookNetwork.getNodes().get(j)).BFS();

			}
		}

		String str4 = "Facebook Social Network – The Highest Node for Betweenness is ";
		String str5 = " and the value is ";
		String str6 = "Facebook Social Network – The Highest Node for Closeness is ";

		PathFinding.betwennesDisplay(str4, str5);
		PathFinding.closenessDisplay(str6, str5);

//		karateClub.display();

	}
}