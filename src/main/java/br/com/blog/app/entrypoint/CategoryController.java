package br.com.blog.app.entrypoint;

import br.com.blog.app.dataprovider.dto.CategoryRequestDTO;
import br.com.blog.app.dataprovider.mapper.CategoryConverter;
import br.com.blog.core.usecase.port.ICategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/blog")
public class CategoryController {

    private final ICategoryUseCase categoryUseCase;
    private final CategoryConverter categoryConverter;

    public CategoryController(ICategoryUseCase categoryUseCase, CategoryConverter categoryConverter) {
        this.categoryUseCase = categoryUseCase;
        this.categoryConverter = categoryConverter;
    }


    @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(
            @RequestBody CategoryRequestDTO request){
        var entity = categoryConverter.toDomain(request);
        categoryUseCase.createCategory(entity);
    }
}
