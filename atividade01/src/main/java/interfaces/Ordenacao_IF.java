package interfaces;
import schemas.Filme;

public interface Ordenacao_IF {
    
    void BubbleSort(Filme[] filmes);
    void QuickSort(Filme[] filmes, int left, int right);
    void QuickSortRandom(Filme[] filmes, int left, int right);
    void MergeSort(Filme[] filmes, int inicio, int fim);
    void CountingSort(Filme[] filmes);
}
