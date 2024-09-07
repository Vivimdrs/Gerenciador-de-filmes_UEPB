package utils;

import interfaces.Ordenacao_IF;
import schemas.Filme;

public class Ordenacao implements Ordenacao_IF {

    public void swap(Filme[] filmes, int i, int j){
        Filme temp = filmes[i];
        filmes[i] = filmes[j];
        filmes[j] = temp;
    }

    @Override
    public void BubbleSort(Filme[] filmes){
        int n = filmes.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(filmes[j].compareTo(filmes[j+1]) > 0){
                    swap(filmes, j, j+1);
                }
            }
        }
    }

    @Override
    public void MergeSort(Filme[] filmes, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2;

            MergeSort(filmes, inicio, meio);
            MergeSort(filmes, meio + 1, fim);

            merge(filmes, inicio, meio, fim);
        }
    }
    
    private void merge(Filme[] filmes, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        Filme[] left = new Filme[n1];
        Filme[] right = new Filme[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = filmes[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = filmes[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (left[i].getNota() >= right[j].getNota()) {
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

    private int partition(Filme[] filmes, int left, int right, Filme pivot) {
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (filmes[i].getNota() <= pivot.getNota()) {
                i++;
            } else if (filmes[j].getNota() > pivot.getNota()) {
                j--;
            } else {
                swap(filmes, i, j);
            }
        }
        
        swap(filmes, left, j);
        return j;
    }

    @Override
    public void QuickSort(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pivot = partition(filmes, left, right, filmes[left]);
            QuickSort(filmes, left, pivot - 1);
            QuickSort(filmes, pivot + 1, right);
        }
    }

    @Override
    public void QuickSortRandom(Filme[] filmes, int left, int right) {
        if (left < right) {
            int randomIndex = left + (int) (Math.random() * (right - left + 1));
            swap(filmes, left, randomIndex);
            int pivot = partition(filmes, left, right, filmes[left]);
            QuickSortRandom(filmes, left, pivot - 1);
            QuickSortRandom(filmes, pivot + 1, right);
        }
    }

    @Override
    public void CountingSort(Filme[] filmes) {
        int k = 10;
        
        Filme[] output = new Filme[filmes.length];
        
        int[] C = new int[k + 1];
        
        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }
        
        for (int j = 0; j < filmes.length; j++) {
            C[filmes[j].getNota()]++;
        }
        
        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }
        
        for (int j = filmes.length - 1; j >= 0; j--) {
            int nota = filmes[j].getNota();
            output[C[nota] - 1] = filmes[j];
            C[nota]--;
        }
        
        for (int i = 0; i < filmes.length; i++) {
            filmes[i] = output[i];
        }
    }
}
