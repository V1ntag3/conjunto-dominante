package heuristico;

import java.util.Vector;

public class ConjuntoDominanteHeuristico {
	static Vector<Integer> grafo[];
	static boolean box[] = new boolean[100000];

	static Vector<Integer> Dominant(int ver, int edge) {
		Vector<Integer> S = new Vector<Integer>(); // set S
		for (int i = 0; i < ver; i++) {
			if (!box[i]) {
				S.add(i);
				box[i] = true;
				for (int j = 0; j < (int) grafo[i].size(); j++) {
					if (!box[grafo[i].get(j)]) {
						box[grafo[i].get(j)] = true;
						break;
					}
				}
			}
		}
		return S;
	}

	public static void main(String[] args) {
		int ver, edge, x, y;

		ver = 6; // Enter number of vertices
		edge = 7; // Enter number of Edges
		grafo = new Vector[ver];
		for (int i = 0; i < ver; i++)
			grafo[i] = new Vector<Integer>();

//	    grafo[0].add(1);
//	    grafo[0].add(2);
//	    grafo[2].add(4);
//	    grafo[2].add(3);
//	    grafo[4].add(5);
//	    grafo[4].add(7);
//	    grafo[7].add(6);
//	    grafo[5].add(6);

		grafo[0].add(1);
		grafo[0].add(4);
		grafo[1].add(2);
		grafo[2].add(5);
		grafo[4].add(5);
		grafo[2].add(3);
		grafo[2].add(5);

		Vector<Integer> S = Dominant(ver, edge);
		System.out.print("The Dominant Set is : { ");
		for (int i = 0; i < (int) S.size(); i++)
			System.out.print(S.get(i) + " ");
		System.out.print("}");
	}

}
