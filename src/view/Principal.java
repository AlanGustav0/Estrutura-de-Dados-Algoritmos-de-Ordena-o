package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import control.AlgoritimosDeOrdenacao;
import entity.GeradorDeValores;

public class Principal {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		GeradorDeValores gerador = new GeradorDeValores();

		int tamanhoVetor = 0;
		int posicao = 0;
		int opc = 0;
		int i;
		double tempoInicial, tempoFinal, tempoTotal;
		String nomeArquivo;

		gerador.geraValores();

		String fileName = "valoresGerados.txt";
		BufferedReader ler = new BufferedReader(new FileReader(fileName));
		AlgoritimosDeOrdenacao alg = new AlgoritimosDeOrdenacao();

		int vetor[] = new int[gerador.getqtdValores()];
		tamanhoVetor = vetor.length;
		String linha = ler.readLine();

		while (linha != null) {
			vetor[posicao] = Integer.parseInt(linha);
			linha = ler.readLine();
			posicao++;
		}

		alg.setVetor(vetor);

		while (opc != 9) {
			System.out.println(
					"Escolha o algoritmo de ordenação desejado:\n1-BubbleSort\n2-SelectionSort\n3-InsertionSort\n4-QuickSort\n5-Gerar novos valores\n9-Finalizar");
			opc = sc.nextInt();

			switch (opc) {
			case 1:

				nomeArquivo = "valoresBubbleSort.txt";
				BufferedWriter writerBubble = new BufferedWriter(new FileWriter(nomeArquivo));

				System.out.println("Realizando ordenação, aguarde...");
				tempoInicial = System.nanoTime();
				alg.Bubblesort();
				tempoFinal = System.nanoTime();
				tempoTotal = tempoFinal - tempoInicial;
				tempoTotal /= Math.pow(10, 9);

				writerBubble.write("Tempo total para ordenação: " + tempoTotal + "s\nQuantidade de valores gerados: "
						+ gerador.getqtdValores() + "\n");
				writerBubble.newLine();

				for (i = 0; i < vetor.length; i++) {
					writerBubble.write(Integer.toString(vetor[i]) + " ");
				}

				writerBubble.close();

				System.out.println("Arquivo ordenado com sucesso!");
				System.out.println("Tempo total de execução BubbleSort: \n" + tempoTotal + "s");
				break;

			case 2:

				nomeArquivo = "valoresSelection.txt";
				BufferedWriter writerSelection = new BufferedWriter(new FileWriter(nomeArquivo));

				System.out.println("Realizando ordenação, aguarde...");
				tempoInicial = System.nanoTime();
				alg.selectionSort();
				tempoFinal = System.nanoTime();
				tempoTotal = tempoFinal - tempoInicial;
				tempoTotal /= Math.pow(10, 9);

				writerSelection.write("Tempo total para ordenação: " + tempoTotal + "s\nQuantidade de valores gerados: "
						+ gerador.getqtdValores() + "\n");
				writerSelection.newLine();

				for (i = 0; i < vetor.length; i++) {
					writerSelection.write(Integer.toString(vetor[i]) + " ");
				}
				writerSelection.close();

				System.out.println("Arquivo ordenado com sucesso!");
				System.out.println("Tempo total de execução SelectionSort: \n" + tempoTotal + "s");
				break;

			case 3:

				nomeArquivo = "valoresInsertion.txt";
				BufferedWriter writerInsertion = new BufferedWriter(new FileWriter(nomeArquivo));

				System.out.println("Realizando ordenação, aguarde...");
				tempoInicial = System.nanoTime();
				alg.insertionSort();
				tempoFinal = System.nanoTime();
				tempoTotal = tempoFinal - tempoInicial;
				tempoTotal /= Math.pow(10, 9);

				writerInsertion.write("Tempo total para ordenação: " + tempoTotal + "s\nQuantidade de valores gerados: "
						+ gerador.getqtdValores() + "\n");
				writerInsertion.newLine();

				for (i = 0; i < vetor.length; i++) {
					writerInsertion.write(Integer.toString(vetor[i]) + " ");
				}
				writerInsertion.close();

				System.out.println("Arquivo ordenado com sucesso!");
				System.out.println("Tempo total de execução InsertionSort: \n" + tempoTotal + "s");
				break;

			case 4:

				/*
				 * Para ordenar uma lista com 50 mil números, pode ocorrem o erro de
				 * StackOverFlow (estouro da pilha), caso isso ocorra será necessário alterar o
				 * aumentar a capacidade da pilha.
				 * 
				 * No eclipse Caminho: Run/Run Configurations/Arguments/VM arguments insira
				 * -Xss16m
				 */

				nomeArquivo = "valoresQuickSort.txt";
				BufferedWriter writerQuick = new BufferedWriter(new FileWriter(nomeArquivo));

				System.out.println("Realizando ordenação, aguarde...");
				tempoInicial = System.nanoTime();
				alg.quickSort(0, tamanhoVetor - 1);
				tempoFinal = System.nanoTime();
				tempoTotal = tempoFinal - tempoInicial;
				tempoTotal /= Math.pow(10, 9);

				writerQuick.write("Tempo total para ordenação: " + tempoTotal + "s\nQuantidade de valores gerados: "
						+ gerador.getqtdValores() + "\n");
				writerQuick.newLine();

				for (i = 0; i < vetor.length; i++) {
					writerQuick.write(Integer.toString(vetor[i]) + " ");
				}
				writerQuick.close();

				System.out.println("Arquivo ordenado com sucesso!");
				System.out.println("Tempo total de execução QuickSort: \n" + tempoTotal + "s");
				break;

			case 5:
				gerador.geraValores();
				System.out.println("");
				break;

			case 9:
				System.out.println("Finalizado!");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		}

		ler.close();

	}

}
