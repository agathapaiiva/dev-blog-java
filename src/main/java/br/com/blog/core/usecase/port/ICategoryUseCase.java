package br.com.blog.core.usecase.port;

import br.com.blog.core.domain.model.Category;
import br.com.blog.core.domain.repository.CategoryEntity;

public interface ICategoryUseCase {

    void createCategory(Category category);

    Iterable<CategoryEntity> findAllCategory();

    void deleteByIdCategory(Integer id);

}
