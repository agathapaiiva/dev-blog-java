package br.com.blog.core.usecase.impl;

import br.com.blog.core.domain.exception.InvalidCategoryException;
import br.com.blog.core.domain.mapper.ConverterDomain;
import br.com.blog.core.domain.model.Article;
import br.com.blog.core.domain.repository.IArticleEntity;
import br.com.blog.core.usecase.port.IArticleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.Objects.*;

@Service
@AllArgsConstructor
public class ArticleUseCaseImpl implements IArticleUseCase {

    @Autowired
    private IArticleEntity articleEntity;

    private final ConverterDomain converterDomain;

    @Override
    public void createArticle(Article article) {

        var getArticle = articleEntity.findByTitle(article.title());
        if(nonNull(article) && isNull(getArticle)){
            var request = converterDomain.toEntity(article);
            articleEntity.save(request);
            return;
        }
        throw new InvalidCategoryException("[ERROR] - Title already registered");
    }
}
