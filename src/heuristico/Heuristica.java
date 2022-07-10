package heuristico;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Vertice {
	int node;
	int vertice;

	public Vertice(int vertice, int node) {
		this.vertice = vertice;
		this.node = node;
	}
}

public class Heuristica {
	static Vector<Integer> grafo[];
	static ArrayList<Integer> dominantes = new ArrayList<Integer>();
	static Vertice registroVertice[];
	static boolean visitados[] = new boolean[100000];
	static int verticesLivres = 0;

	public static void sort(Vertice registroVertice[]) {
		for (int j = 1; j < registroVertice.length; j++) {
			Vertice chave = registroVertice[j];
			int i = j - 1;
			while (i >= 0 && registroVertice[i].node < chave.node) {
				registroVertice[i + 1] = registroVertice[i];
				i = i - 1;
			}

			registroVertice[i + 1] = chave;
		}

	}

	public static void processar(int index) {
		int vertice = registroVertice[index].vertice;
		if (!visitados[vertice])
			verticesLivres--;
		visitados[vertice] = true;

		for (int i = 0; i < grafo[vertice].size(); i++) {
			int vizinho = grafo[vertice].get(i);
			if (visitados[vizinho]) {
				registroVertice[index].node--;
			} else {
				visitados[vizinho] = true;
				verticesLivres--;
			}
		}

		if (registroVertice[index].node >= 1) {
			dominantes.add(vertice);
		}

		if (verticesLivres <= 0) {
			return;
		} else {
			processar(index + 1);
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int qntVertices, qntArestas;

		System.out.print("Digite quantos vertices: ");
		qntVertices = input.nextInt();
		System.out.print("Digite quantas arestas: ");
		qntArestas = input.nextInt();

		verticesLivres = qntVertices;
		grafo = new Vector[qntVertices+1];
		registroVertice = new Vertice[qntVertices];

		for (int i = 0; i < qntVertices; i++) {
			grafo[i] = new Vector<Integer>();
			registroVertice[i] = new Vertice(i, 0);
		}

		System.out.println("Digite o grafo x - y");
		for (int i = 0; i < qntArestas; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			grafo[x].add(y);
			grafo[y].add(x);
			registroVertice[x].node++;
			registroVertice[y].node++;
		}

		input.close();

		long start = System.nanoTime();
		sort(registroVertice);
		processar(0);
		long finish = System.nanoTime();

		System.out.println("Tempo: " + (finish - start));

		System.out.println("Vertices dominantes");
		for (int i = 0; i < dominantes.size(); i++) {
			System.out.print(dominantes.get(i)+" ");
		}

	}

}
