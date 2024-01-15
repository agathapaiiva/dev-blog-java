package br.com.blog.core.usecase.port;

import br.com.blog.core.domain.model.Category;

public interface ICategoryUseCase {

    void createCategory(Category category);
}
