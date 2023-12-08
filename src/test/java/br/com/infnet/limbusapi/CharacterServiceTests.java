package br.com.infnet.limbusapi;

import br.com.infnet.limbusapi.model.Character;
import br.com.infnet.limbusapi.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterServiceTests {
	Logger logger = LoggerFactory.getLogger(CharacterService.class);
	@Autowired
	CharacterService characterService;

	@Test
	void TestGetAll() {
		List<Character> characters = characterService.getAll();
		assertEquals(13, characters.size());
	}

	@Test
	void TestGetById() {
		int id = 1;
		Optional<Character> optionalCharacter = characterService.getById(id);
		Character character = optionalCharacter.get();
		logger.info(character.toString());
		assertEquals("Yi Sang", character.getName());
	}

	@Test
	void TestDeleteCharacter() {
		int id = 1;
		Optional<Character> character = characterService.getById(id);
		assertNotNull(character);
		characterService.deleteById(id);
		Optional<Character> deletedCharacter = characterService.getById(id);
		assertFalse(deletedCharacter.isEmpty());
	}

}
