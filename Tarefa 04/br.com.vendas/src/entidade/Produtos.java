/**
 * @author Flavio
 */
package entidade;

public class Produtos {

    private int id;
    private String descricao;
    private Double valor_unitario;
    private Double qtde_estoque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Double getQtde_estoque() {
        return qtde_estoque;
    }

    public void setQtde_estoque(Double qtde_estoque) {
        this.qtde_estoque = qtde_estoque;
    }

}
