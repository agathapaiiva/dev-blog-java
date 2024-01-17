package br.com.blog.core.usecase.port;

import br.com.blog.core.domain.model.Article;

public interface IArticleUseCase {

    void createArticle(Article article);
}
