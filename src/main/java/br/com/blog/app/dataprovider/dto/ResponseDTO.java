package br.com.blog.app.dataprovider.dto;

import lombok.Builder;

@Builder
public record ResponseDTO(String message, Integer code) {
}
