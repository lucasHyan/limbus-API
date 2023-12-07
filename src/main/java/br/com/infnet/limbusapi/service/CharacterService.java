package br.com.infnet.limbusapi.service;

import br.com.infnet.limbusapi.exception.ResourceNotFoundException;
import br.com.infnet.limbusapi.model.Character;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CharacterService {
    private Map<Long, Character> characters = initCharacter();

    private Map<Long, Character> initCharacter() {
        Map<Long, Character> characters = new HashMap<>();

        characters.put((long) 1, Character.builder()
                .name("Yi Sang")
                .bookQuote("‘박제가 되어버린 천재’를 아시오? ")
                .englishBookQuote("Have you heard of the taxidermied genius?")
                .gender("Male")
                .sinnerNumber("1")
                .color("#d4dfe8")
                .literarySource("The Wings")
                .voiceActor("Min Seung-woo")
                .build());


        characters.put((long) 2, Character.builder()
                .name("Faust")
                .bookQuote("Es irrt der Mensch, solang er strebt.")
                .englishBookQuote("Man errs, as long as he strives.")
                .gender("Female")
                .sinnerNumber("2")
                .color("#ffbfb4")
                .literarySource("Goethe's Faust")
                .voiceActor("Park Ji-yoon")
                .build());

        characters.put((long) 3, Character.builder()
                .name("Don Quixote")
                .bookQuote("¡Por alcanzar la estrella inalcanzable!")
                .englishBookQuote("To reach the unreachable star!")
                .gender("Female")
                .sinnerNumber("3")
                .color("#FFEF23")
                .literarySource("The Ingenious Gentleman Don Quixote of La Mancha")
                .voiceActor("Kim Yea-lim")
                .build());

        characters.put((long) 4, Character.builder()
                .name("Ryōshū")
                .bookQuote("かいなでの絵師には総じて醜いものの美しさなどと申すことは、わかろうはずがございませぬ。")
                .englishBookQuote("Other lesser painters are such mediocrities, they have no way to recognize the beauty that lies in ugliness.")
                .gender("Female")
                .sinnerNumber("4")
                .color("#cf0000")
                .literarySource("Hell Screen")
                .voiceActor("Lee Sae-ah")
                .build());

        characters.put((long) 5, Character.builder()
                .name("Meursault")
                .bookQuote("Aujourd'hui, j'ai tué maman. Ou peut-être était-ce hier.")
                .englishBookQuote("Today, I killed mother. Or maybe it was yesterday.")
                .gender("Male")
                .sinnerNumber("5")
                .color("#293b95")
                .literarySource("The Stranger")
                .voiceActor("Kwon Sung-hyuk")
                .build());

        characters.put((long) 6,Character.builder()
                .name("Hong Lu")
                .bookQuote("美中不足、 好事多魔。")
                .englishBookQuote("Jade has its flaws, and life its vicissitudes.")
                .gender("Male")
                .sinnerNumber("6")
                .color("#5BFFDE")
                .literarySource("Dream of the Red Chamber")
                .voiceActor("Kim Sin-woo")
                .build());

        characters.put((long) 7, Character.builder()
                .name("Heathcliff")
                .bookQuote("I have not broken your heart - YOU have; and in breaking it, you have broken mine.")
                .englishBookQuote("I have not broken your heart - YOU have; and in breaking it, you have broken mine.")
                .gender("Male")
                .sinnerNumber("7")
                .color("#4e3076")
                .literarySource("Wuthering Heights")
                .voiceActor("Hong Seung-hyo")
                .build());

        characters.put((long) 8, Character.builder()
                .name("Ishmael")
                .bookQuote("If you please, call me Ishmael.")
                .englishBookQuote("If you please, call me Ishmael.")
                .gender("Female")
                .sinnerNumber("8")
                .color("#ff9500")
                .literarySource("Moby-Dick")
                .voiceActor("Jang Ye-na")
                .build());

        characters.put((long) 9, Character.builder()
                .name("Rodion")
                .bookQuote("Он бы хотел совсем забыться, все забыть, потом проснуться и начать совсем сызнова.")
                .englishBookQuote("If she could forget everything, and begin afresh.")
                .gender("Female")
                .sinnerNumber("9")
                .color("#820000")
                .literarySource("Crime and Punishment")
                .voiceActor("Yoon A-young")
                .build());

        characters.put((long) 10, Character.builder()
                .name("Dante")
                .bookQuote("Lasciate ogne speranza, voi ch'intrate. ")
                .englishBookQuote("Abandon hope, all ye who enters here.")
                .gender(null)
                .sinnerNumber("10")
                .color("#b01c37")
                .literarySource("Dante's Inferno")
                .voiceActor(null)
                .build());

        characters.put((long) 11, Character.builder()
                .name("Sinclair")
                .bookQuote("Die böse Welt indessen begann schon mitten in unserem eigenen Hause.")
                .englishBookQuote("Meanwhile, the world of evil began there already, right in the middle of our house.")
                .gender("Male")
                .sinnerNumber("11")
                .color("#8b9c15")
                .literarySource("Demian: The Story of Emil Sinclair's Youth")
                .voiceActor("Kim Da-ol")
                .build());

        characters.put((long) 12, Character.builder()
                .name("Outis")
                .bookQuote("Είμαι... ου τις απολύτως.")
                .englishBookQuote("I am... nothing at all.")
                .gender("Female")
                .sinnerNumber("12")
                .color("#325339")
                .literarySource("(The) Odyssey")
                .voiceActor("Kim Bo-na")
                .build());

        characters.put((long) 13, Character.builder()
                .name("Gregor")
                .bookQuote("Als ich aus unruhigen Träumen erwachte, hatte ich mich in ein ungeheures Ungeziefer verwandelt." )
                .englishBookQuote("As I awoke from unsettling dreams, I had transformed into some hideous pest.")
                .gender("Male")
                .sinnerNumber("13")
                .color("#69350b")
                .literarySource("The Metamorphosis")
                .voiceActor("Choi Han")
                .build());

        return characters;
    }
    public List<Character> getAll(){
        return characters.values().stream().toList();
    }

    public Optional<Character> getById(Long id) {
        Character character = characters.get(id);
        if(character == null) return Optional.empty();
        return Optional.of(character);
    }

    public Character deleteById(Long id) {
        if(!characters.containsKey(id)) {
            throw new ResourceNotFoundException("Character not found.");
        }
        Character removed = characters.remove(id);
        return removed;
    }
}
