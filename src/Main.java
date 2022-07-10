import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Digite quantos vertices e arestas: ");
			int vertices = input.nextInt();
			int arestas = input.nextInt();
			Grafo g = new Grafo(vertices);

			System.out.println("Digite x e y: ");
			for (int i = 0; i < arestas; i++) {
				int x = input.nextInt();
				int y = input.nextInt();

				g.adicionarAresta(x, y);
			}

			long start = System.nanoTime();
			g.mcd();
			long finish = System.nanoTime();
			for (int z : g.mcd())
				System.out.print(z + " ");
			System.out.println("Tempo: " + (finish - start) + "tamanho");
		}

	}

}
