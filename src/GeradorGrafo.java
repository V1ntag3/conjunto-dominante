import java.util.Random;

public class GeradorGrafo {

	public static void main(String[] args) {
		int arestas = 500;
		int listaAresta[] = new int[arestas+1 ];
		Random gerador = new Random();

		for (int i = 0; i < arestas; i += 2) {
			listaAresta[i] = i;
			listaAresta[i + 1] = gerador.nextInt(arestas - 1) + 1;
		}

		for (int i = 0; i < listaAresta.length; i++) {
			System.out.println(listaAresta[i] + " " + listaAresta[i + 1]);
		}

	}
}
