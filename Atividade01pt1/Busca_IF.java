package Atividade01pt1;
import java.util.List;

public interface Busca_IF {
    
    boolean checaVetorOrdenado(Filme[] filmes);
    List<Filme> BuscaLinearIterativa(Filme[] filmes, int nota) throws Exception;
    List<Filme> BuscaLinearRecursiva(Filme[] filmes, int nota, int pos) throws Exception;
    List<Filme> BuscaBinariaIterativa(Filme[] filmes, int nota) throws Exception;
    List<Filme> BuscaBinariaRecursiva(Filme[] filmes, int nota) throws Exception;

}
