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
        }
    }
   // TODO metodo merge;


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
