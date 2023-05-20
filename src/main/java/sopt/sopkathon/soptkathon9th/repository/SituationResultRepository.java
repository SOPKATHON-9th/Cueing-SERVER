package sopt.sopkathon.soptkathon9th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.sopkathon.soptkathon9th.domain.Situation;
import sopt.sopkathon.soptkathon9th.domain.SituationResult;

import java.util.Optional;

public interface SituationResultRepository extends JpaRepository<SituationResult, Long> {

    Optional<SituationResult> findBySituation(Situation situation);
}
