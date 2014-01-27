package es.usc.supostos.domain;


public class Alumno {

    private String nome;
    private String apelido1;
    private String apelido2;

    public Alumno() {
    }

    public Alumno(String apelido1, String apelido2, String nome) {
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido1() {
        return apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }    

    @Override
    public String toString() {
        return apelido1 + " " + apelido2 + ", " + nome;
    }
}
