package br.com.blog.app.dataprovider.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record ArticleRequestDTO(@NonNull String title, @NonNull String text, @NonNull String date) {
}
