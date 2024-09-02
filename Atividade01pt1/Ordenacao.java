package Atividade01pt1;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void QuickSort(Filme[] filmes){

    }
    @Override
    public void QuickSortRamdom(Filme[] filmes){

    }
    @Override
    public void CountingSort(Filme[] filmes){

    }
   
}
