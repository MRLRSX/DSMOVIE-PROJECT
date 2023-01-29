package br.com.mrlrsx.dsmovie.repositories;

import br.com.mrlrsx.dsmovie.entities.Score;
import br.com.mrlrsx.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
