package sopt.sopkathon.soptkathon9th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sopt.sopkathon.soptkathon9th.domain.Client;
import sopt.sopkathon.soptkathon9th.domain.Situation;
import sopt.sopkathon.soptkathon9th.domain.SituationProceed;

public interface SituationProceedRepository extends JpaRepository<SituationProceed, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE SituationProceed  s SET s.isProceed = true WHERE s.client = ?1 AND s.situation = ?2")
    void changeSituationProceedState(Client client, Situation situation);
}
