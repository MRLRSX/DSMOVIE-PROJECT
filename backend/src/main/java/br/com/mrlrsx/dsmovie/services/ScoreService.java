package br.com.mrlrsx.dsmovie.services;

import br.com.mrlrsx.dsmovie.dto.MovieDTO;
import br.com.mrlrsx.dsmovie.dto.ScoreDTO;
import br.com.mrlrsx.dsmovie.entities.Movie;
import br.com.mrlrsx.dsmovie.entities.Score;
import br.com.mrlrsx.dsmovie.entities.User;
import br.com.mrlrsx.dsmovie.repositories.MovieRepository;
import br.com.mrlrsx.dsmovie.repositories.ScoreRepository;
import br.com.mrlrsx.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;


    public MovieDTO saveScore(ScoreDTO entity){
        User user = userRepository.findByEmail(entity.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(entity.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(entity.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValor(entity.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValor();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
