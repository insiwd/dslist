package com.insiwd.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insiwd.dslist.dto.GameMinDTO;
import com.insiwd.dslist.entities.Game;
import com.insiwd.dslist.repositories.GameRepository;

// registramos como componente
@Service
public class GameService {
 
    // injetamos dependencia
    @Autowired
    private GameRepository gameRepository;
    

    // o meu service devolve um DTO
    public List<GameMinDTO> findAll() {
        
        // pode ser "var result =" também
        List<Game> result = gameRepository.findAll();

        // mapeando uma lista de games em lista de GameMinDTO
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
