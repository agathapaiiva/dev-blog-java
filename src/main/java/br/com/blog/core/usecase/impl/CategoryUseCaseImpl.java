package br.com.blog.core.usecase.impl;

import br.com.blog.core.domain.exception.InvalidCategoryException;
import br.com.blog.core.domain.mapper.ConverterDomain;
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

    private final ConverterDomain converterDomain;

    @Override
    public void createCategory(Category category) {
        var getCategory = categoryEntity.findByName(category.name());
        if (nonNull(category) && isNull(getCategory)) {

            var request = converterDomain.toEntity(category);
                categoryEntity.save(request);
                return;
            }
        throw new InvalidCategoryException("[ERROR] - Category already registered");
    }

    @Override
    public Iterable<CategoryEntity> findAllCategory() {
        return categoryEntity.findAll();
    }

    @Override
    public void deleteByIdCategory(Integer id) {
        var category  = categoryEntity.findById(id);
        if(nonNull(category)){
            categoryEntity.deleteById(id);
            return;
        }
        throw new InvalidCategoryException("[ERROR] - Category not found in the database");
    }
}
