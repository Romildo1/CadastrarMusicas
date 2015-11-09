
package acervo;

/**
 *
 * @author romildo
 */
import java.sql.*;

public class Conexao {
    //Metodo para Conectar ao Banco de Dados Local chamado 'cadastro_de_musicas', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/cadastro_de_musicas", "root", "laser");
			return(c);
		} catch (ClassNotFoundException e) {
			System.out.println("Problema na configuracao do Driver do MySQL!");
		} catch (SQLException e) {
			System.out.println("Problema na conexao com o banco de dados!");
		}
		return(null);
	}
	
	//Emite o relatório contendo dados do Banco
          public static ResultSet relatorio() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
                return(st.executeQuery("SELECT k.nome as Genero, q.nome as Artista, j.nome as Album, y.nome as Musica, y.Nota as Nota FROM genero k, artista q, album j, musica y WHERE (y.album = j.id AND j.artista = q.id AND q.genero = k.id );"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela album!");
            }
            return(null);
	}
          
        public static ResultSet relatorioAlbum() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM album;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela album!");
            }
            return(null);
	}
        
        public static ResultSet relatorioArtista() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM artista;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela Artista!");
            }
            return(null);
	}
        
        public static ResultSet relatorioGenero() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM genero;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela genero!");
            }
            return(null);
	}
        
	public static ResultSet relatorioMusica() {
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM musica;"));
            } catch (SQLException e) {
		System.out.println("Problema na consulta na tabela musica!");
            }
            return(null);
	}
	
	
	public static int inserirAlbum(Album j, int id) {
            String insercao = "INSERT INTO album (nome, ano, artista) VALUES ('"+j.getNome()+"',"+j.getAno()+", "+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Album!");
            }
            return(0);
	}
        
        public static int inserirArtista(Artista q, int id) {
            String insercao = "INSERT INTO artista (nome, tempo_de_carreira, genero) VALUES ('"+q.getNome()+"',"+q.getTempoDeCarteira()+", "+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Artista!");
            }
            return(0);
	}
       
        public static int inserirGenero(Genero k) {
            String insercao = "INSERT INTO genero (nome) VALUES ('"+k.getNome()+"');";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Genero!");
            }
            return(0);
	}
        public static int inserirMusica(Musica y, int id) {
            String insercao = "INSERT INTO musica (nome,nota,duracao, album) VALUES ('"+y.getNome()+"',"+y.getNota()+","+y.getDuracao()+","+id+");";
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeUpdate(insercao));
            } catch (SQLException e) {
            	System.out.println("Problema na inserção da Musica!");
            }
            return(0);
	}
        
        public static ResultSet buscarAlbum(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM (album) where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela album!");
            }
            return(null);
	}
        
        public static ResultSet buscarArtista(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM (artista) where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela artista!");
            }
            return(null);
	}
        
        public static ResultSet buscarGenero(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM (genero) where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela genero!");
            }
            return(null);
	}
        
        public static ResultSet buscarMusica(String nome){
            Connection con = conectar();
            Statement st;
            try {
            	st = con.createStatement();
            	return(st.executeQuery("SELECT * FROM (musica) where(nome like '"+nome+"%');"));
            } catch (SQLException e) {
		System.out.println("Problema na pesquisar na tabela musica!");
            }
            return(null);
	}
}

