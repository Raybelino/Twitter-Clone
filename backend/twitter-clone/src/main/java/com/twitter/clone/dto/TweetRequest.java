package com.twitter.clone.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TweetRequest {

    @NotBlank(message = "El contenido del tweet no puede estar vacío")
    @Size(max = 280, message = "El tweet no puede tener más de 280 caracteres")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}