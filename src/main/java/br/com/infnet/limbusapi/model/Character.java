package br.com.infnet.limbusapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Character {
    private String name;
    private String bookQuote;
    private String englishBookQuote;
    private String gender;
    private String sinnerNumber;
    private String color;
    private String literarySource;
    private String voiceActor;

}
