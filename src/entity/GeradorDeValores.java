package entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeradorDeValores {

	static int vetor[];
	private int qtdValores;

	public boolean pertence(int valor, int tam) {
		for (int i = 0; i < tam; i++) {
			if (vetor[i] == valor) {
				return true;
			}
		}
		return false;
	}

	public void geraValores() throws IOException {

		Scanner sc = new Scanner(System.in);

		String nomeArquivo = "valoresGerados.txt";

		BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));

		System.out.print("Insira a quantidade de valores que deseja gerar:  ");
		vetor = new int[sc.nextInt()];

		qtdValores = vetor.length;

		int valor;
		int posicao;

		System.out.println("O arquivo esta sendo gerado, aguarde...");
		// gerando valores aleatorios
		for (posicao = 0; posicao < vetor.length; posicao++) {
			do {
				valor = (int) (Math.random() * 100000) % 100000;
			} while (pertence(valor, posicao));
			vetor[posicao] = valor;

			writer.write(Integer.toString(vetor[posicao]));
			writer.newLine();

		}
		writer.close();
		
		System.out.println("");
		System.out.println("Arquivo gerado com sucesso!");

	}

	public int getqtdValores() {
		return qtdValores;
	}

}
