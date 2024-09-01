package Atividade01pt1;

public interface Ordenacao_IF {
    
    public void BubbleSort(Filme[] filmes);
    public void QuickSort(Filme[] filmes);
    public void QuickSortRamdom(Filme[] filmes); //com shuffle
    public void MergeSort(Filme[] filmes, int inicio, int fim);
    public void CountingSort(Filme[] filmes);
}
