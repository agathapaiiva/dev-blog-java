package br.com.blog.app.dataprovider.mapper;

import br.com.blog.app.dataprovider.dto.ArticleRequestDTO;
import br.com.blog.app.dataprovider.dto.CategoryRequestDTO;
import br.com.blog.core.domain.model.Article;
import br.com.blog.core.domain.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ConverterProvider {

    public Category toDomain(CategoryRequestDTO dto){
        return Category.builder()
                .name(dto.name())
                .build();
    }

    public Article toDomain(ArticleRequestDTO dto){
        return Article.builder()
                .title(dto.title())
                .text(dto.text())
                .date(dto.date())
                .build();
    }
}
