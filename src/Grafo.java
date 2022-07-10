
import java.util.ArrayList;

public class Grafo {
	ArrayList<ArrayList<Integer>> Grafo;
	int V;

	Grafo(int vertices) {
		V = vertices;
		Grafo = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			Grafo.add(new ArrayList<Integer>());

		}
	}

	void adicionarAresta(int v, int u) {
		Grafo.get(v).add(u);
		Grafo.get(u).add(v);
	}

	void printarGrafo() {
		for (int i = 0; i < V; i++) {
			System.out.print("Vertice " + (i) + ": ");
			for (int x : Grafo.get(i))
				System.out.print("-> " + x);
			System.out.println();
		}
	}

	int[] mcd() {
		int[] f = { -1 };
		ArrayList<Integer> visitados = new ArrayList<Integer>();
		Combinacao comb1;
		int[] vertices = new int[V];
		int[] saida;
		int contador = 0;

		for (int i = 0; i < V; i++) {
			vertices[i] = i;
		}

		for (int j = 1; j <= V; j++) {
			comb1 = new Combinacao(vertices, j);
			while (comb1.hasNext()) {
				saida = comb1.next();
				for (int x : saida) {
					if (!visitados.contains(x)) {
						contador++;
						visitados.add(x);
					}
					//if(Grafo.get(x).get(0) == null) {
						
					//}
					for (int y : Grafo.get(x)) {
						if (!visitados.contains(y)) {
							contador++;
							visitados.add(y);

						}
					}

				}

				if (contador == V)
					return saida;
				contador = 0;
				visitados.clear();
			}

		}
		return f;

	}

}
