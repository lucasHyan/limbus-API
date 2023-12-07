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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	void TestGetById(){
		Long id = 1L;
		Optional<Character> character = characterService.getById(id);
		logger.info(character.toString());
		assertNotNull(character);
//		assertEquals("Yi Sang", character);
	}

}
