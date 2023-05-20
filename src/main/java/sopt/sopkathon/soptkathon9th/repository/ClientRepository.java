package sopt.sopkathon.soptkathon9th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.sopkathon.soptkathon9th.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
