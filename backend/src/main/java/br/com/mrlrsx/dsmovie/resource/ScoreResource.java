package br.com.mrlrsx.dsmovie.resource;

import br.com.mrlrsx.dsmovie.dto.MovieDTO;
import br.com.mrlrsx.dsmovie.dto.ScoreDTO;
import br.com.mrlrsx.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/scores")
public class ScoreResource {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        MovieDTO movieDTO = service.saveScore(dto);
        return movieDTO;
    }
}
