package br.com.mrlrsx.dsmovie.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name="tb_score")
public class Score implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ScorePK id = new ScorePK();

    private Double valor;

    public Score() {
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public ScorePK getId() {
        return id;
    }

    public void setId(ScorePK id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double value) {
        this.valor = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score score)) return false;
        return Objects.equals(id, score.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
