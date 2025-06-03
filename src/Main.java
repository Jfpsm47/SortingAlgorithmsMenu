import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int op;
        int[] lista = {5, 3, 8, 4, 2, 1, 10, 7, 9, 6};

        do {
            System.out.print("""
                    Menu
                1- Bubble Sort
                2 - Selection Sort
                3 - Quick Sort
                4 - Counting Sort
                >>> """);
            op = input.nextInt();

            // Bubble Sort
            if(op == 1){
                int n = lista.length;

                for (int i = 0; i < n -1; i++){
                    for (int j = 0; j < n-1; j++){
                        if (lista[j] > lista[j + 1]){
                            int aux = lista[j];
                            lista[j] = lista[j+1];
                            lista[j+1] = aux;
                        }
                    }
                }
                System.out.println("Lista ordenada pelo Bubble Sort...");
                System.out.println(Arrays.toString(lista));
            }
            // Selection Sort
            if(op == 2){
                int n = lista.length;

                for (int i = 0; i < n - 1; i++){
                   int menorValor = i;

                   for (int j = i+ 1; j < n; j++){
                       if(lista[j] < lista[menorValor]){
                           menorValor = j;
                       }
                   }
                   int aux = lista[menorValor];
                   lista[menorValor] = lista[i];
                   lista[i] = aux;


                }
                System.out.println("Lista ordenada pelo Selection Sort...");
                System.out.println(Arrays.toString(lista));

            }
            //Quick Sort
            if(op == 3){
                int inicio = 0;
                int fim = lista.length - 1;

                quickSort(lista,inicio,fim);

                System.out.println("Lista ordenada pelo Quick Sort...");
                System.out.println(Arrays.toString(lista));
            }
            //Counting Sort
            if (op == 4){
                int n = lista.length;

                int maior = lista[0];
                for (int i = 1;i < n;i++){
                    if (lista[i] > maior){
                        maior = lista[i];
                    }
                }

                int[] contagem = new int[maior + 1];

                for (int j : lista) {
                    contagem[j]++;
                }

                int index = 0;
                for (int i = 0; i<= maior;i++){
                    while (contagem[i] > 0){
                        lista[index] = i;
                        index++;
                        contagem[i]--;
                    }
                }
                System.out.println("Lista ordenada pelo Counting Sort...");
                System.out.println(Arrays.toString(lista));
            }
        }while (op != 15);


    }
    public static void quickSort(int[] lista, int inicio, int fim){
        if(inicio < fim){
            int pivo = lista[fim];
            int i = inicio - 1;

            for (int j = inicio; j < fim; j++){
                if(lista[j] <= pivo){
                    i++;
                    int aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }

            int aux = lista[i+1];
            lista[i+1] = lista[fim];
            lista[fim] = aux;

            int indicePivo = i + 1;

            quickSort(lista,inicio,indicePivo - 1);
            quickSort(lista,indicePivo + 1, fim);
        }
    }
}
// TODO: insertionSort
// TODO: mergeSort
// TODO: shellSort
// TODO: collectionsSort
// TODO: bogoSort
// TODO: heapSort
// TODO: timSort
// TODO: bucketSort
// TODO: radixSort
// TODO: gnomeSort
