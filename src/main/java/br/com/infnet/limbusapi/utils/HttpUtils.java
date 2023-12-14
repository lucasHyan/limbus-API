package br.com.infnet.limbusapi.utils;

import br.com.infnet.limbusapi.model.Character;
import br.com.infnet.limbusapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HttpUtils {
    @Autowired
    CharacterService characterService;

    public HttpHeaders getHttpHeaders(Integer size, int page) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("total-size", String.valueOf(characterService.count()));
        httpHeaders.set("total-pages", String.valueOf(characterService.getTotalPages(size)));
        httpHeaders.set("current-page", String.valueOf(page));
        return httpHeaders;
    }
}