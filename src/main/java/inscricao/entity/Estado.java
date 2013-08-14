package inscricao.entity;

import java.io.Serializable;

public class Estado implements Serializable {
    private Integer codigo;
    private String descricao;

    public Estado() {
    }

    public Estado(Integer codigo) {
        this.codigo = codigo;
    }

    public Estado(Integer codigo, String descricao) {
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