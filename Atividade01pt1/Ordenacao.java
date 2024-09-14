package Atividade01pt1;

public class Ordenacao implements Ordenacao_IF {

    public void swap(Filme[] filmes, int i, int j){
        Filme temp = filmes[i];
        filmes[i] = filmes[j];
        filmes[j] = temp;
    }
    @Override
    public void BubbleSort(Filme[] filmes){
        int n = filmes.length;
        for(int i = 0; i< n-1; i++){            //CONCLUIDO
            for(int j = 0; j<n-i-1; j++){
                if(filmes[j].compareTo(filmes[j+1]) > 0){
                    swap(filmes, j, j+1);
                }
            }
        }

    }
    @Override
    public void MergeSort(Filme[] filmes, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim)/2;

            MergeSort(filmes, inicio, meio);
            MergeSort(filmes, meio+1, fim);

            merge(filmes, inicio, meio, fim);
        }
    }
    
    private void merge(Filme[] filmes, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;
    
        Filme[] left = new Filme[n1];
        Filme[] right = new Filme[n2];
    
        // Copiando os elementos para os arrays auxiliares
        for (int i = 0; i < n1; i++) {
            left[i] = filmes[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = filmes[meio + 1 + j];
        }
    
        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if ((left[i].compareTo(right[j])) <= 0) {
                filmes[k] = left[i];
                i++;
            } else {
                filmes[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            filmes[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            filmes[k] = right[j];
            j++;
            k++;
        }
    }
    private int partition(Filme[] filmes, int left, int right) {
        Filme pivot = filmes[right]; // Usando o último elemento como pivô
        int i = left - 1; // Índice do menor elemento
    
        for (int j = left; j < right; j++) {
            if (filmes[j].compareTo(pivot) < 0) {
                i++;
                swap(filmes, i, j);
            }
        }
        swap(filmes, i + 1, right); // Coloca o pivô na posição correta
        return i + 1; // Retorna o índice do pivô
    }
    @Override
    public void QuickSort(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(filmes, left, right);
            
            // Chama o QuickSort para as sublistas esquerda e direita
            QuickSort(filmes, left, pivotIndex - 1);
            QuickSort(filmes, pivotIndex + 1, right);
        }
    }
    
    
    
    
    @Override
    public void QuickSortRandom(Filme[] filmes, int left, int right) {
        if (left < right) {
            int randomIndex = left + (int) (Math.random() * (right - left + 1));
            swap(filmes, left, randomIndex);
            int pivot = partition(filmes, left, right);
            QuickSortRandom(filmes, left, pivot - 1);
            QuickSortRandom(filmes, pivot + 1, right);
        }
    }

    @Override
    public void CountingSort(Filme[] filmes) {
        // Defina o intervalo fixo das notas (0 a 5)
        int k = 5; // O valor máximo de nota é 5
    
        // Crie o array de contagem e o array de saída
        Filme[] output = new Filme[filmes.length];
        int[] C = new int[k + 1]; // O índice vai de 0 a k
    
        // Inicialize o array de contagem com zeros
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
    
        // Preencha o array de contagem com o número de ocorrências de cada nota
        for (Filme filme : filmes) {
            int nota = filme.getNota();
            C[nota]++;
        }
    
        // Atualize o array de contagem para armazenar a posição final de cada elemento
        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }
    
        // Construa o array de saída
        for (int j = filmes.length - 1; j >= 0; j--) {
            int nota = filmes[j].getNota();
            output[C[nota] - 1] = filmes[j];
            C[nota]--;
        }
    
        // Copie o array de saída para o array original
        System.arraycopy(output, 0, filmes, 0, filmes.length);
    }
}
