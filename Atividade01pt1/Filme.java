package Atividade01pt1;

public class Filme implements Filme_IF{
    private String nome;
    private int nota;
    private int ano;

    Filme(String nome, int nota, int ano){
        this.nome = nome;
        this.nota = nota;
        this.ano = ano;
    }
    @Override
    public int getAno(){
        return ano;
    }
    @Override
    public int getNota(){
        return nota;
    }
    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public void setAno(int ano){
        this.ano = ano;
    }
    @Override
    public void setNome(String nome){
        this.nome = nome;
    }
    @Override
    public int compareTo(Filme outro) {
        if (this.nota != outro.getNota()) {
            return Integer.compare(outro.getNota(), this.nota); 
        }
        else if (this.ano != outro.getAno()) {
            return Integer.compare(this.ano, outro.getAno()); 
        }
        else {
            return this.nome.compareTo(outro.getNome()); 
        }
    }

    @Override
    public String toString(){
        return
               nome + "("+ano+")" + "["+nota+"]";
    }
    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }
}   