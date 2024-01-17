package br.com.blog.core.domain.model;

import lombok.Builder;

@Builder
public record Article(String title, String text, String date){
}
