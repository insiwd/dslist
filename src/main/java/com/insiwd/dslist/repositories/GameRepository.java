package com.insiwd.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insiwd.dslist.entities.Game;

// nome da entidade a ser mapeada, tipo do ID
public interface GameRepository extends JpaRepository<Game, Long> {

}
