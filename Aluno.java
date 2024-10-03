public class Aluno extends Usuario {
    private String perfilAcademico;
    private String curriculo;

    public Aluno(int id, String nome, String email, String senha, String perfilAcademico, String curriculo) {
        super(id, nome, email, senha);
        this.perfilAcademico = perfilAcademico;
        this.curriculo = curriculo;
    }

    // Getters e setters
}
