package br.com.mrlrsx.dsmovie.resource;

import br.com.mrlrsx.dsmovie.dto.MovieDTO;
import br.com.mrlrsx.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(@PageableDefault(size = 12) Pageable pageable){
        Page<MovieDTO> movieDTOPage = movieService.findAll(pageable);
        return ResponseEntity.ok().body(movieDTOPage);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<MovieDTO> findByID(@PathVariable Long id){
        MovieDTO movieDTO = movieService.findById(id);
        return ResponseEntity.ok().body(movieDTO);
    }
}
