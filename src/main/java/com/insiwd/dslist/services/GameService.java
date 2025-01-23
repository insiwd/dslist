package com.insiwd.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insiwd.dslist.dto.GameDTO;
import com.insiwd.dslist.dto.GameMinDTO;
import com.insiwd.dslist.entities.Game;
import com.insiwd.dslist.projections.GameMinProjection;
import com.insiwd.dslist.repositories.GameRepository;

// registramos como componente
@Service
public class GameService {
 
    // injetamos dependencia
    @Autowired
    private GameRepository gameRepository;
    
    // colocamos essa anotação em toda classe do service!!
    // eu não vou fazer nenhuma operação de escrita, fica mais rápido assim
    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        // o '.get()' é pra pegar o valor dentro do findById
        Game result = gameRepository.findById(gameId).get();
        
        // convertendo Game para GameDTO
        return new GameDTO(result);
    }

    // o meu service devolve um DTO
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        
        // pode ser "var result =" também
        List<Game> result = gameRepository.findAll();

        // mapeando uma lista de games em lista de GameMinDTO
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }
}
