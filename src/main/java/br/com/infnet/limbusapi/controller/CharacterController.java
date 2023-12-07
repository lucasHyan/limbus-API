package br.com.infnet.limbusapi.controller;

import br.com.infnet.limbusapi.exception.ResourceNotFoundException;
import br.com.infnet.limbusapi.model.Character;
import br.com.infnet.limbusapi.payload.ResponsePayload;
import br.com.infnet.limbusapi.service.CharacterService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    CharacterService characterService;
    @GetMapping
    public List<Character> getAll(){
        return characterService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable Long id){
        try{
            Character character = characterService.getById(id)
                      .orElseThrow(() -> new ResourceNotFoundException("Character not found."));
            return ResponseEntity.ok(character);
        } catch(ResourceNotFoundException ex){
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        try {
            Character removed = characterService.deleteById(id);
            return ResponseEntity.ok(removed);
        }catch (ResourceNotFoundException ex){
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }
}
