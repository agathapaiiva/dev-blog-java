package br.com.blog.core.domain.mapper;

import br.com.blog.core.domain.model.Article;
import br.com.blog.core.domain.model.Category;
import br.com.blog.core.domain.repository.ArticleEntity;
import br.com.blog.core.domain.repository.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class ConverterDomain {

    public CategoryEntity toEntity(Category category){
        return CategoryEntity.builder()
                .name(category.name())
                .build();
    }

    public ArticleEntity toEntity(Article article){
        return ArticleEntity.builder()
                .title(article.title())
                .text(article.text())
                .date(article.date())
                .build();
    }
}
