package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AlgoritimosDeOrdenacao {

	private int vetor[];

	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}

	public void Bubblesort() throws IOException {

		int iteracao;
		int posicao;
		int auxiliar;

		// System.out.println("Realizando Bubblesort em um vetor de " + vetor.length + "
		// elementos");
		for (iteracao = 0; iteracao < vetor.length; iteracao++) {
			for (posicao = 0; posicao < vetor.length - iteracao - 1; posicao++) {
				if (vetor[posicao] > vetor[posicao + 1]) {
					auxiliar = vetor[posicao];
					vetor[posicao] = vetor[posicao + 1];
					vetor[posicao + 1] = auxiliar;
				}
			}
			// System.out.println("--------------Final da iteracao: " + iteracao);
			// mostravetor();
		}

	}

	public void selectionSort() throws IOException {
		int iteracao, temp;
		int posMenorInicial;
		int posMenor;
		int i;

		for (iteracao = 0; iteracao < vetor.length - 1; iteracao++) {
			posMenorInicial = iteracao;
			posMenor = iteracao + 1;
			for (i = posMenor + 1; i < vetor.length; i++) {
				if (vetor[i] < vetor[posMenor]) {
					posMenor = i;
				}

			}
			// System.out.println("Menor Elemento encontrado na iteração esta na posição " +
			// posMenor);
			if (vetor[posMenor] < vetor[posMenorInicial]) {
				temp = vetor[posMenorInicial];
				vetor[posMenorInicial] = vetor[posMenor];
				vetor[posMenor] = temp;

			}

			// writer.newLine();

			// System.out.println("Iteração " + iteracao);
			// mostravetor();
		}

	}

	public void insertionSort() throws IOException {
		int carta, iteracao, j;

		// a iteracao vai selecionar a carta da vez e então puxar todos os elementos que
		// "puxar" todos os elementos que são maiores que ele.

		for (iteracao = 1; iteracao < vetor.length; iteracao++) {
			carta = vetor[iteracao]; // guardo a carta
			for (j = iteracao - 1; (j >= 0) && vetor[j] > carta; j--) {
				vetor[j + 1] = vetor[j]; // estou trocando todos maiores do que eu
			}
			vetor[j + 1] = carta;

			// System.out.println("Iteração " + iteracao);
			// mostravetor();
		}

	}

	public int particao(int inicio, int fim) {
		int pivo, acima, abaixo, auxiliar;

		// Definindo nosso pivo e variáveis de inicio e fim
		pivo = vetor[inicio];
		abaixo = inicio;
		acima = fim;

		// enquanto o INICIO for menor do que o FIM
		while (abaixo < acima) {

			// encontrando um numero maior que o pivo
			while (vetor[abaixo] <= pivo && abaixo < fim) {
				// avançamos porque queremos encontrar um valor maior
				abaixo++;
			}

			// tambem queremos encontrar a partir do fim um valor menor que o meu pivo
			while (vetor[acima] > pivo) {
				acima--;
			}

			if (abaixo < acima) { // eles não se cruzaram nos indices
				// troca
				auxiliar = vetor[abaixo];
				vetor[abaixo] = vetor[acima];
				vetor[acima] = auxiliar;
			}

		}

		vetor[inicio] = vetor[acima];
		vetor[acima] = pivo;

		return acima; // no final das contas é a posicao de ACIMA que denota onde está o pivô

	}

	public void quickSort(int inicio, int fim) {
		int pivo;

		if (inicio >= fim) {
			return;
		}

		// Aqui garantimos que todos os elementos com valor "abaixo" do pivo sejam
		// menores e todos os elementos "acima" do pivô sejam maiores
		pivo = particao(inicio, fim);

		// feita essa definição, aplicamos o quickSort nos elementos do inicio até o
		// valor antes do pivô
		quickSort(inicio, pivo - 1);
		// E aplicamos o quickSort nos elementos do valor acima do pivô até o final.
		quickSort(pivo + 1, fim);

		// mostravetor();

	}

	public void mostravetor() {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println("");
	}

}
