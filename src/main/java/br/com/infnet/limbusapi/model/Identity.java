package br.com.infnet.limbusapi.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Identity {
    private String name;
    private int rarity;
    private String world;
    private String quote;
}
