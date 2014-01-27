package es.usc.supostos.domain;

public class Alumno implements Comparable<Alumno> {

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
        return new StringBuilder(apelido1).append(" ").append(apelido2).append(", ").append(nome).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Alumno)) {
            return false;
        }

        Alumno alumno = (Alumno) obj;

        return getNome().equals(alumno.getNome())
                && getApelido1().equals(alumno.getApelido1())
                && getApelido2().equals(alumno.getApelido2());
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + apelido1.hashCode() + apelido2.hashCode();
    }

    @Override
    public int compareTo(Alumno o) {
        int result = apelido1.compareTo(o.getApelido1());

        if (result == 0) {
            result = apelido2.compareTo(o.getApelido2());

            if (result == 0) {
                result = nome.compareTo(o.getNome());
            }
        }

        return result;
    }

}
