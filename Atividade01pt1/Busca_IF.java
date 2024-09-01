package Atividade01pt1;

public interface Busca_IF {
    
    boolean checaVetorOrdenado(Filme[] filmes);
    Filme BuscaLinearIterativa(Filme[] filmes, int nota) throws Exception;
    Filme BuscaLinearRecursiva(Filme[] filmes, int nota, int pos) throws Exception;
    Filme BuscaBinariaIterativa(Filme[] filmes, int nota) throws Exception;
    Filme BuscaBinariaRecursiva(Filme[] filmes, int nota) throws Exception;

}
