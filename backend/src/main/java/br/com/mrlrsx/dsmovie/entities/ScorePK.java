package br.com.mrlrsx.dsmovie.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ScorePK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Movie movie;
    private User user;

    public ScorePK() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
