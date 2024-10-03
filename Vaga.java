public class Vaga {
    private int id;
    private String titulo;
    private String descricao;
    private String requisitos;
    private String tipo; // Remoto ou presencial
    private Empresa empresa;

    public Vaga(int id, String titulo, String descricao, String requisitos, String tipo, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.tipo = tipo;
        this.empresa = empresa;
    }

    // Getters e setters
}
 //{
    
//}
