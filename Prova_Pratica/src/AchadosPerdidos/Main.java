package AchadosPerdidos;

import javax.swing.JOptionPane;

interface Publicacao {
    String buscarTitulo(String titulo);
    void visualizarDetalhes();
}

class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

class AchadoPerdido implements Publicacao {
    private String titulo;
    private String descricao;
    private String foto;
    private String tipo;
    private String localAchado;
    private String dataHora;
    private String status;

    public AchadoPerdido(String titulo, String descricao, String tipo, String status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
    }

    public void completaDados(String foto, String localAchado, String dataHora) {
        this.foto = foto;
        this.localAchado = localAchado;
        this.dataHora = dataHora;
    }

    public String buscarTitulo(String titulo) {
        if (this.titulo.equals(titulo)) {
            return "Título: " + this.titulo + "\nDescrição: " + this.descricao + "\nLocal Achado: " + this.localAchado;
        } else {
            return "Pertence não foi encontrado.";
        }
    }

    public void visualizarDetalhes() {
        String mensagem = "Título: " + titulo + "\nFoto: " + foto + "\nLocal Achado: " + localAchado + "\nTipo: " + tipo + "\nStatus: " + status;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}

class Encontrar {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Jean", "jean@gmail.com", "senha: 1278");
        AchadoPerdido achado = new AchadoPerdido("Chave", "Chave encontrada na rua", "Objeto Pessoal", "Encontrado");
        achado.completaDados("fotochave.jpg", "Rua Dona Luci", "05.10.2023 16:26:30");

        String tituloBuscado = "Chave";
        String detalhesAchado = achado.buscarTitulo(tituloBuscado);
        JOptionPane.showMessageDialog(null, detalhesAchado);


        achado.visualizarDetalhes();
    }
}
