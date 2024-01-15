package br.com.blog.app.dataprovider.mapper;

import br.com.blog.app.dataprovider.dto.CategoryRequestDTO;
import br.com.blog.core.domain.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category toDomain(CategoryRequestDTO dto){
        return Category.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }
}
