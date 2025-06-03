import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int MIN_MERGE = 32; // Constante para o TimSort

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op;
        int[] lista = {5, 3, 8, 4, 2, 1, 10, 7, 9, 6};

        do {

            System.out.println("MENU");
            System.out.println(" 1 - Bubble Sort");
            System.out.println(" 2 - Selection Sort");
            System.out.println(" 3 - Quick Sort");
            System.out.println(" 4 - Counting Sort");
            System.out.println(" 5 - Shell Sort");
            System.out.println(" 6 - Bogo Sort");
            System.out.println(" 7 - Gnome Sort");
            System.out.println(" 8 - Radix Sort");
            System.out.println(" 9 - Bucket Sort");
            System.out.println(" 10 - Tim Sort");
            System.out.println(" 15 - Sair");

            op = input.nextInt();

            if (op == 1) {
                int n = lista.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (lista[j] > lista[j + 1]) {
                            int aux = lista[j];
                            lista[j] = lista[j + 1];
                            lista[j + 1] = aux;
                        }
                    }
                }
                System.out.println("Lista Ordenada pelo Bubble Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 2) {
                int n = lista.length;

                for (int i = 0; i < n - 1; i++) {
                    int menorValor = i;

                    for (int j = i + 1; j < n; j++) {
                        if (lista[j] < lista[menorValor]) {
                            menorValor = j;
                        }
                    }
                    int aux = lista[menorValor];
                    lista[menorValor] = lista[i];
                    lista[i] = aux;

                }
                System.out.println("Lista Ordenada pelo Selection Sort: ");
                System.out.println(Arrays.toString(lista));
            }

            if (op == 3) {
                int inicio = 0;
                int fim = lista.length - 1;

                quickSort(lista, inicio, fim);
                System.out.println("Lista Ordenada pelo Quick Sort: ");
                System.out.println(Arrays.toString(lista));
            }

            if (op == 4) {
                int n = lista.length;

                int maior = lista[0];
                for (int i = 1; i < n; i++) {
                    if (lista[i] > maior) {
                        maior = lista[i];
                    }
                }

                int[] contagem = new int[maior + 1];

                for (int j : lista) {
                    contagem[j]++;
                }
                int index = 0;
                for (int i = 0; i <= maior; i++) {
                    while (contagem[i] > 0) {
                        lista[index] = i;
                        index++;
                        contagem[i]--;
                    }
                }
                System.out.println("Lista Ordenada pelo Counting Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 5) {
                shellSort(lista);
                System.out.println("Lista Ordenada pelo Shell Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 6) {  dsffsfd
                bogoSort(lista);
                System.out.println("Lista Ordenada pelo Bogo Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 7) {
                int i = 0;
                int n = lista.length;

                while (i < n) {
                    if (i == 0 || lista[i] >= lista[i - 1]) {
                        i++;
                    } else {
                        int temp = lista[i];
                        lista[i] = lista[i - 1];
                        lista[i - 1] = temp;
                        i--;
                    }
                }
                System.out.println("Lista Ordenada pelo Gnome Sort: ");
                System.out.println(Arrays.toString(lista));

            }
            if (op == 8) {
                radixSort(lista);
                System.out.println("Lista Ordenada pelo Radix Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 9) {
                bucketSort(lista);
                System.out.println("Lista Ordenada pelo Bucket Sort: ");
                System.out.println(Arrays.toString(lista));
            }
            if (op == 10) {
                timSort(lista);
                System.out.println("Lista Ordenada pelo Tim Sort: ");
                System.out.println(Arrays.toString(lista));
            }

        } while (op != 15);
    }

    public static void quickSort(int[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = lista[fim];
            int i = inicio - 1;

            for (int j = inicio; j < fim; j++) {
                if (lista[j] <= pivo) {
                    i++;
                    int aux = lista[i];
                    lista[i] = lista[j];
                    lista[j] = aux;
                }
            }

            int aux = lista[i + 1];
            lista[i + 1] = lista[fim];
            lista[fim] = aux;

            int indicePivo = i + 1;

            quickSort(lista, inicio, indicePivo - 1);
            quickSort(lista, indicePivo + 1, fim);

        }
    }

    public static void shellSort(int[] lista) {
        int n = lista.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = lista[i];
                int j;


                for (j = i; j >= gap && lista[j - gap] > temp; j -= gap) {
                    lista[j] = lista[j - gap];
                }
                lista[j] = temp;
            }
        }
    }

    public static void bogoSort(int[] lista) {
        Random rand = new Random();
        while (!isSorted(lista)) {
            for (int i = 0; i < lista.length; i++) {
                int randomIndex = rand.nextInt(lista.length);
                int temp = lista[i];
                lista[i] = lista[randomIndex];
                lista[randomIndex] = temp;
            }
        }
    }

    public static boolean isSorted(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            if (lista[i] > lista[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static int getMax(int[] lista) {
        int mx = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > mx) {
                mx = lista[i];
            }
        }
        return mx;
    }

    public static void countingSort(int[] lista, int exp) {
        int n = lista.length;
        int[] output = new int[n]; // Array para armazenar os elementos ordenados
        int[] count = new int[10]; // Array para contar as ocorrências de cada dígito (0-9)
        Arrays.fill(count, 0);

        // Inicializa o array de contagem com zeros
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        // Conta as ocorrências de cada dígito na posição especificada
        for (int i = 0; i < n; i++) {
            int digit = (lista[i] / exp) % 10;
            count[digit]++;
        }

        // Modifica o array de contagem para armazenar a posição de cada dígito
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Preenche o array de saída com os elementos ordenados
        for (int i = n - 1; i >= 0; i--) {
            int digit = (lista[i] / exp) % 10;
            output[count[digit] - 1] = lista[i];
            count[digit]--;
        }
        // Copia os elementos ordenados de volta para a matriz original
        for (int i = 0; i < n; i++) {
            lista[i] = output[i];
        }

    }

    public static void radixSort(int[] lista) {
        int max = getMax(lista);
        // Aplica Counting Sort para cada dígito, do menos significativo ao mais significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(lista, exp);
        }
    }

    public static void bucketSort(int[] lista) {
        if (lista.length == 0) return;

        // Encontrar os valores máximo e mínimo
        int minValor = lista[0];
        int maxValor = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] < minValor) {
                minValor = lista[i];
            } else if (lista[i] > maxValor) {
                maxValor = lista[i];
            }
        }

        // Número de baldes - podemos ajustar isso conforme necessário
        int bucketCount = (maxValor - minValor) / lista.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);

        // Inicializar os baldes
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribuir os elementos nos baldes
        for (int valor : lista) {
            int bucketIndex = (valor - minValor) / lista.length;
            buckets.get(bucketIndex).add(valor);
        }

        // Ordenar cada balde e concatenar os resultados
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int valor : bucket) {
                lista[index++] = valor;
            }
        }
    }
    public static void insertionSort(int[] lista, int esquerda, int direita){
        for(int i = esquerda + 1; i <= direita; i++){
            int temp = lista[i];
            int j = i - 1;
            while (j >= esquerda && lista[j] > temp){
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = temp;
        }
    }

    public static void merge(int[] lista, int l, int m, int r){
        int len1 = m - l + 1, len2 = r - m;
        int[] esquerda = new int[len1];
        int[] direita = new int[len2];

        for (int x = 0; x < len1; x++) esquerda[x] = lista[l + x];
        for (int x = 0; x < len2; x++) direita[x] = lista[m + 1 + x];

        int i = 0, j = 0, k = l;

        while (i < len1 && j < len2) {
            if (esquerda[i] <= direita[j]) {
                lista[k++] = esquerda[i++];
            } else {
                lista[k++] = direita[j++];
            }
        }

        while (i < len1) lista[k++] = esquerda[i++];
        while (j < len2) lista[k++] = direita[j++];

    }

    public static void timSort(int[] lista){
        int n = lista.length;

        for (int i = 0; i < n; i += MIN_MERGE) {
            insertionSort(lista, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = MIN_MERGE; size < n; size = 2 * size) {
            for (int esquerda = 0; esquerda < n; esquerda += 2 * size) {
                int mid = esquerda + size - 1;
                int direita = Math.min((esquerda + 2 * size - 1), (n - 1));
                if (mid < direita) {
                    merge(lista, esquerda, mid, direita);
                }
            }
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
