public class Aluno extends Usuario {
    private String perfilAcademico;
    private String descricao;
    private byte[] curriculo; // VARBINARY

    // Construtor
    public Aluno(Long id, String nome, String senha, String perfilAcademico, String descricao, byte[] curriculo) {
        super(id, nome, senha, "aluno");
        this.perfilAcademico = perfilAcademico;
        this.descricao = descricao;
        this.curriculo = curriculo;
    }

    // Getters e Setters
    public String getPerfilAcademico() {
        return perfilAcademico;
    }

    public void setPerfilAcademico(String perfilAcademico) {
        this.perfilAcademico = perfilAcademico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(byte[] curriculo) {
        this.curriculo = curriculo;
    }
}
