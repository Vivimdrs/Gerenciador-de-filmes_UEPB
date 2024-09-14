package Atividade01pt1;

public interface Filme_IF extends Comparable<Filme> {

    public String getNome();

    public void setNome(String nome);

    public int getNota();

    public void setNota(int nota);

    public int getAno();

    public void setAno(int ano);

    @Override
    public int compareTo(Filme outrofilme);

    @Override
    public String toString();

}
