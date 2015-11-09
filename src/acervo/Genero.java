
package acervo;

/**
 *
 * @author romildo
 */
public class Genero {
     private String nome;

    public Genero(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void ListaGenero(){
        System.out.println("Nome "+nome);
    }
}

