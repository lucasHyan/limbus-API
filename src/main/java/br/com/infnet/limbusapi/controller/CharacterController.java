package br.com.infnet.limbusapi.controller;

import br.com.infnet.limbusapi.exception.ResourceNotFoundException;
import br.com.infnet.limbusapi.model.Character;
import br.com.infnet.limbusapi.payload.ResponsePayload;
import br.com.infnet.limbusapi.service.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    Logger logger = LoggerFactory.getLogger(CharacterController.class);
    @Autowired
    CharacterService characterService;

    @GetMapping
    public List<Character> getAll(@RequestParam(required = false, defaultValue = "13")Integer size,
                                  @RequestParam(required = false, defaultValue = "") String sort,
                                  @RequestParam(required = false, defaultValue = "") String order,
                                  @RequestParam(required = false, defaultValue = "1") int start,
                                  @RequestParam(required = false, defaultValue = "10") int end,
                                  @RequestParam(required = false, defaultValue = "1") int page) {
        logger.info(size.toString());
        return characterService.getAll(size,sort,order);
    }

    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable int id) {
        try {
            Character character = characterService.getById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Character not found."));
            return ResponseEntity.ok(character);
        } catch (ResourceNotFoundException ex) {
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        try {
            Character removed = characterService.deleteById(id);
            return ResponseEntity.ok(removed);
        } catch (ResourceNotFoundException ex) {
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable int id, @RequestBody Character character) {
        try {
            Character updated = characterService.updateById(id, character);
            return ResponseEntity.ok(updated);
        } catch (ResourceNotFoundException ex) {
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Character character) {
        try {
            Character created = characterService.createCharacter(character);
            return ResponseEntity.ok(created);
        } catch (ResourceNotFoundException ex) {
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsePayload);
        }
    }
}
