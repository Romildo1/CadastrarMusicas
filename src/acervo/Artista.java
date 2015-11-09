
package acervo;

/**
 *
 * @author romildo
 */
public class Artista {
    private String nome;
    private int tempo_de_carreira;

    public Artista(String nome, int tempoDeCarteira) {
        this.nome = nome;
        this.tempo_de_carreira = tempoDeCarteira;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoDeCarteira() {
        return tempo_de_carreira;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempoDeCarteira(int tempoDeCarteira) {
        this.tempo_de_carreira = tempoDeCarteira;
    }
    
    public void ListaArtista(){
        System.out.println("Nome "+nome);
        System.out.println("Tempo De Carreira "+tempo_de_carreira);
    }
}

