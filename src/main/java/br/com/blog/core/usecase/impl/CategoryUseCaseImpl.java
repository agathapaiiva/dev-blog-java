package br.com.blog.core.usecase.impl;

import br.com.blog.core.domain.exception.InvalidCategoryException;
import br.com.blog.core.domain.model.Category;
import br.com.blog.core.domain.repository.CategoryEntity;
import br.com.blog.core.domain.repository.ICategoryEntity;
import br.com.blog.core.usecase.port.ICategoryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class CategoryUseCaseImpl implements ICategoryUseCase {

    @Autowired
    private ICategoryEntity categoryEntity;

    @Override
    public void createCategory(Category category) {
        var getCategory = categoryEntity.findByName(category.name());
        if (nonNull(category) && isNull(getCategory)) {
            var request = CategoryEntity.builder()
                   .id(category.id())
                        .name(category.name())
                        .build();
                categoryEntity.save(request);
                return;
            }
        throw new InvalidCategoryException("[ERROR] - Category already registered");
    }
}
