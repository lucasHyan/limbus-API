package br.com.infnet.limbusapi;

import br.com.infnet.limbusapi.exception.ResourceNotFoundException;
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
	void testCreateCharacter() {
		Character character = Character.builder()
				.name("Outis")
				.bookQuote("Είμαι... ου τις απολύτως.")
				.englishBookQuote("I am... nothing at all.")
				.gender("Female")
				.sinnerNumber(12)
				.color("#325339")
				.literarySource("(The) Odyssey")
				.voiceActor("Kim Bo-na")
				.build();

		Character result = characterService.createCharacter(character);
		logger.info(result.toString());
		assertEquals(character, result);
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

	@Test
	void testUpdateNonExistingCharacter() {
		int id = 20;
		Character character = new Character();

		List<Character> allCharacters = characterService.getAll();
		allCharacters.forEach(c -> logger.info(c.toString()));

		assertThrows(ResourceNotFoundException.class, () -> {
			characterService.updateById(id, character);
		});
	}
}
