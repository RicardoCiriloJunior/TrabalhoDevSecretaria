package org.example.model;

public class Disciplina {
    private long id;
    private String disciplina;

    public long getId() {
        return id;
    }

    public Disciplina(){}

    public Disciplina(String disciplina){
        this.disciplina = disciplina;
    }
    public Disciplina(long id, String disciplina){
        this.id = id;
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina that = (Disciplina) o;
        return id == that.id;
    }

}
