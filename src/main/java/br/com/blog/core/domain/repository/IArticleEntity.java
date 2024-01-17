package br.com.blog.core.domain.repository;

import org.springframework.data.repository.CrudRepository;

public interface IArticleEntity extends CrudRepository<ArticleEntity, Integer> {

    IArticleEntity findByTitle(String title);
}
