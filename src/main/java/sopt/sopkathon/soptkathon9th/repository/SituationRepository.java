package sopt.sopkathon.soptkathon9th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sopt.sopkathon.soptkathon9th.domain.Situation;
import sopt.sopkathon.soptkathon9th.domain.SituationIn;
import sopt.sopkathon.soptkathon9th.domain.SituationWhat;
import sopt.sopkathon.soptkathon9th.domain.SituationWhere;

import java.util.Optional;

public interface SituationRepository extends JpaRepository<Situation, Long> {
    @Query("SELECT s FROM Situation s WHERE s.situationWhat=?1 AND s.situationWhere=?2 AND s.situationIn=?3")
    Optional<Situation> findSituationBySituationData(SituationWhat situationWhat, SituationWhere situationWhere, SituationIn situationIn);
}
