package inscricao.entity;

import java.io.Serializable;

public class Estado2 implements Serializable {
    private Integer codigo;
    private String descricao;

    public Estado2() {
    }

    public Estado2(Integer codigo) {
        this.codigo = codigo;
    }

    public Estado2(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}