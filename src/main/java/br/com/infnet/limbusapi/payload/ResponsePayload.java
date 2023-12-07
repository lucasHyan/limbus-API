package br.com.infnet.limbusapi.payload;

import lombok.Data;

@Data
public class ResponsePayload {
    private String message;

    public ResponsePayload(String message) {
        this.message = message;
    }
}