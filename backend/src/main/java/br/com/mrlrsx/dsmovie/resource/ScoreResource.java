package br.com.mrlrsx.dsmovie.resource;

import br.com.mrlrsx.dsmovie.dto.MovieDTO;
import br.com.mrlrsx.dsmovie.dto.ScoreDTO;
import br.com.mrlrsx.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/scores")
public class ScoreResource {

    @Autowired
    private ScoreService service;

    @PutMapping
    public ResponseEntity<MovieDTO> save(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO = service.saveScore(dto);
        return ResponseEntity.ok().body(movieDTO);
    }
}


