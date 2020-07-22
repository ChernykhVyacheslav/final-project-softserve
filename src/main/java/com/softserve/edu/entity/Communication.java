package com.softserve.edu.entity;

public class Communication {
    private int idStudent;
    private int idMentor;

    public Communication(int idStudent, int idMentor) {
        this.idStudent = idStudent;
        this.idMentor = idMentor;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Communication)) return false;

        Communication that = (Communication) o;

        if (getIdStudent() != that.getIdStudent()) return false;
        return getIdMentor() == that.getIdMentor();
    }

    @Override
    public int hashCode() {
        int result = getIdStudent();
        result = 31 * result + getIdMentor();
        return result;
    }
}
