package com.insiwd.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insiwd.dslist.dto.GameDTO;
import com.insiwd.dslist.dto.GameMinDTO;
import com.insiwd.dslist.services.GameService;

@RestController

// mapeando o recurso
@RequestMapping("/games")
public class GameController {

    // injetamos o service do controller
    // camadas: o controller injeta um service, o service injeta o repository
    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;        
    }    
}
