public class Empresa extends Usuario {
    private String dadosEmpresa;

    public Empresa(int id, String nome, String email, String senha, String dadosEmpresa) {
        super(id, nome, email, senha);
        this.dadosEmpresa = dadosEmpresa;
    }

    // Getters e setters
}
