package java.model;
public class Empresa extends Usuario {
    private String cidade;
    private String descricao;
    private String dadosEmpresa;

    // Construtor
    public Empresa(Long id, String nome, String senha, String cidade, String descricao, String dadosEmpresa) {
        super(id, nome, senha, "empresa");
        this.cidade = cidade;
        this.descricao = descricao;
        this.dadosEmpresa = dadosEmpresa;
    }

    // Getters e Setters
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDadosEmpresa() {
        return dadosEmpresa;
    }

    public void setDadosEmpresa(String dadosEmpresa) {
        this.dadosEmpresa = dadosEmpresa;
    }
}
