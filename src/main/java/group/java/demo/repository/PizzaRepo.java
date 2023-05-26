package group.java.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.java.demo.entity.Pizza;

@Repository
public interface PizzaRepo extends JpaRepository<Pizza, Integer>  {

}
