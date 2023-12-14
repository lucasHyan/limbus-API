package br.com.infnet.limbusapi;

import br.com.infnet.limbusapi.exception.ResourceNotFoundException;
import br.com.infnet.limbusapi.model.Character;
import br.com.infnet.limbusapi.model.Ego;
import br.com.infnet.limbusapi.service.CharacterService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterServiceTests {
	Logger logger = LoggerFactory.getLogger(CharacterService.class);
	CharacterService characterService;

	@BeforeEach
	void init() {
		characterService = new CharacterService();
	}

	@Test
	void TestGetAll() {
		List<Character> characters = characterService.getAll();
		assertEquals(13, characters.size());
	}

	@Test
	void TestGetAllWithSort() {
		List<Character> characters = characterService.getAll("name", "asc");
		assertEquals("D", characters.get(0).getName().substring(0, 1));
		logger.info(characters.get(0).getName());
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

		List<Ego> testListEgo = new ArrayList<>();
		testListEgo.add(Ego.builder()
				.name("Crow's Eye View Yi Sang")
				.quote("Utter to me what you think the ideal is.")
				.affinity("Sloth")
				.abnormality(null)
				.riskLevel("Zayin")
				.build());
		testListEgo.add(Ego.builder()
				.name("4th Match Flame Yi Sang")
				.quote("I burn what I wish to burn.")
				.affinity("Wrath")
				.abnormality("Pyrokinesis")
				.riskLevel("TETH")
				.build());

		Character character = Character.builder()
				.name("TEST CHARACTER")
				.bookQuote("TEST QUOTE")
				.englishBookQuote("TEST ENGLISH QUOTE")
				.gender("Female")
				.sinnerNumber(12)
				.color("#325339")
				.literarySource("TEST LITERARY SOURCE")
				.voiceActor("TEST VOICE ACTOR")
				.egos(testListEgo)
				.build();

		Character result = characterService.createCharacter(character);
		assertNotNull(result);

		// This code is very ugly, I will change it later to a better solution
		assertEquals(character.getName(), result.getName());
		assertEquals(character.getBookQuote(), result.getBookQuote());
		assertEquals(character.getEnglishBookQuote(), result.getEnglishBookQuote());
		assertEquals(character.getGender(), result.getGender());
		assertEquals(character.getSinnerNumber(), result.getSinnerNumber());
		assertEquals(character.getColor(), result.getColor());
		assertEquals(character.getLiterarySource(), result.getLiterarySource());
		assertEquals(character.getVoiceActor(), result.getVoiceActor());
		assertEquals(character.getEgos(), result.getEgos());

		logger.info(result.toString());
	}

	@Test
	void TestDeleteCharacter() {
		int id = 1;
		Optional<Character> character = characterService.getById(id);
		assertNotNull(character);
		characterService.deleteById(id);
		Optional<Character> deletedCharacter = characterService.getById(id);
		assertTrue(deletedCharacter.isEmpty());
	}

	@Test
	void testUpdateNonExistingCharacter() {
		int id = 20;
		Character character = new Character();

		List<Character> allCharacters = characterService.getAll();
		allCharacters.forEach(c -> logger.info(c.toString()));

		assertThrows(ResourceNotFoundException.class, () -> characterService.updateById(id, character));
	}

	@Test
	public void testPageQuantity() {
		int totalPages = characterService.getTotalPages(4);
		assertEquals(4, totalPages);
	}
}
