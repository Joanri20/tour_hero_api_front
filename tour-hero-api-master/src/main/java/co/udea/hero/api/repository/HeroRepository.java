package co.udea.hero.api.repository;

import co.udea.hero.api.model.Hero;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    List<Hero> findByNameContaining(String name);

}
