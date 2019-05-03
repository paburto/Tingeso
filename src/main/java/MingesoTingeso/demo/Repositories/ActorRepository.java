package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findActorById(Long id);
}