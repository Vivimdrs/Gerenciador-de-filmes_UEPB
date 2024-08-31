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
    public void MergeSort(Filme[] filmes){
        int n = filmes.length;
        if(n == 1 ){
            return;
        }
        int meio = filmes.length/2;
        Filme[] lado1 = new Filme[meio];
        Filme[] lado2 = new Filme[filmes.length - meio];

        lado1.clone();
        lado2.clone();

        MergeSort(lado1);
        MergeSort(lado2);

    //TODO merge(lado1, lado2);
    }


    public void QuickSort(Filme[] filmes, int lado1, int lado2){
        if(lado1< lado2){
            int pivot = part(filmes, lado1, lado2);
            QuickSort(filmes, lado1, pivot-1);
            QuickSort(filmes, pivot+1, lado2);
        }
    }
    public int part(Filme[] filmes, int lado1, int lado2){
        Filme p = filmes[lado2];
        int i = lado1+1;
        int j = lado2;
        while (i <= j) {
            if (filmes[i].compareTo(p) <= 0) {
                 i++;
            }
            else if(filmes[j].compareTo(p) <= 0){
                j--;
            }
            else{
                swap(filmes, i, j);
            }
        }
        swap(filmes, lado1, j);
        return j;
    }
    public void CountingSort(Filme[] filmes){
        int k = 5;
        int n = filmes.length;
        Filme[] aux = new Filme[n];

        

    }
}
