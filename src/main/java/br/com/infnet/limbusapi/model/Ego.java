package br.com.infnet.limbusapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Ego {
    private String name;
    private String quote;
    private String affinity;
    private String abnormality;
    private String riskLevel;
}
