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
    private Double value;

    public Score(){}

    public Score(Double value) {
        this.value = value;
    }

    public ScorePK getId() {
        return id;
    }

    public void setId(ScorePK id) {
        this.id = id;
    }
    public void setMovie(Movie movie){
        id.setMovie(movie);
    }

    public void setUser(User user){
        id.setUser(user);
    }
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
