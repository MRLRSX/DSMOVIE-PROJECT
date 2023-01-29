package br.com.mrlrsx.dsmovie.services;

import br.com.mrlrsx.dsmovie.dto.MovieDTO;
import br.com.mrlrsx.dsmovie.entities.Movie;
import br.com.mrlrsx.dsmovie.repositories.MovieRepository;
import br.com.mrlrsx.dsmovie.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        return movieRepository.findAll(pageable).map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        Movie movie = movieOptional.orElseThrow(() -> new ResourceNotFoundException("Not Found !!!"));
        return new MovieDTO(movie);
    }
}
