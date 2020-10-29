# Algoritmos de Ordenação

###### BubbleSort

Este é o algoritimo mais básico para ordenação, indicado apenas para finz didáticos, por conta de sua inificiência de performance.
O Objetivo é percorrer o vetor até que o maior valor esteja no final da lista. Realizando um grande número de comparaçãoes e grande consumo de processamento.

###### SelectionSort

Útil para estruturas lineares, porém assim acomo o BubbleSort realiza um grande número de iterações e percorre o vetor inteiro, mas 
com o objetivo de passar o menor valor para o início da lista, o segundo menor para a segunda posição e assim por diante, reduzindo o tamanho
da lista a cada iteração. O que o torna um pouco mais perfoemático com relação ao Bubblesort.

###### InsertionSort

Também é um algoritmo similiar aos anteriores, mas seu método de ordenação se dá por inserção direta, funciona como uma ordenação de cartas de baralho.
A medida que ele varre a lista vai posicionando os valores n-1 à sua esquerda e n+1 à sua direita.

###### QuickSort

Algortimo baseado no método dividir e conquistar, utiliza de recursividade para realizar a ordenação, e necessita de um 
pivô (elemento que será a referência para realizar a ordenação). Após a definição desse pivô, ele faz o quicksort do lado esquerdo do pivo (valores menores)
e do lado direido do pivô (valores maiores) indepenente se estão odernados ou não, o algoritmo sempre irá deixar o pivô na posição correta.

Ao partir da esquerda para direita **inicio---> valor maior que pivô** ele verifica se o valor é maior do que o pivô, se encontrar o valor maior ele para, e então começa a verificação do 
lado direto. **valor menor que pivô<----fim** realiza o mesmo procedimento até encontrar um valor que seja menor do que o pivô, ao encontrar o valor ele para e realiza a troca entre esses valores.
