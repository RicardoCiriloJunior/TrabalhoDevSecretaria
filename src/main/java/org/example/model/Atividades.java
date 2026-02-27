package org.example.model;

import java.sql.Date;

public class Atividades {
    private long id;
    private String matrAluno;
    private long idDisciplina;
    private String titulo;
    private String descricao;
    private String status;
    private Date dataEntrega;
    private Date dataCriacao;

    // Constructors
    public Atividades() {}

    public Atividades(String matrAluno, long idDisciplina, String titulo, String descricao,
                      String status, Date dataEntrega, Date dataCriacao) {
        this.matrAluno = matrAluno;
        this.idDisciplina = idDisciplina;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataEntrega = dataEntrega;
        this.dataCriacao = dataCriacao;
    }

    public Atividades(long id, String matrAluno, long idDisciplina, String titulo, String descricao,
                      String status, Date dataEntrega, Date dataCriacao) {
        this(matrAluno, idDisciplina, titulo, descricao, status, dataEntrega, dataCriacao);
        this.id = id;
    }

    // Getters and setters
    public long getId() {
        return id;
    }


    public String getMatrAluno() {
        return matrAluno;
    }


    public long getIdDisciplina() {
        return idDisciplina;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getStatus() {
        return status;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public String toString() {
        return "Atividades{" +
                "id=" + id +
                ", matrAluno='" + matrAluno + '\'' +
                ", idDisciplina=" + idDisciplina +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividades)) return false;
        Atividades that = (Atividades) o;
        return id == that.id;
    }
}
