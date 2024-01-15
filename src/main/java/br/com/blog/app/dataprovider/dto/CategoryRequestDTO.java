package br.com.blog.app.dataprovider.dto;

import lombok.Builder;
import lombok.NonNull;

import java.io.Serializable;

@Builder
public record CategoryRequestDTO(@NonNull String name, Integer id) implements Serializable {
}
