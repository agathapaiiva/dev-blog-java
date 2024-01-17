package br.com.blog.app.entrypoint;

import br.com.blog.app.dataprovider.dto.CategoryRequestDTO;
import br.com.blog.app.dataprovider.mapper.ConverterProvider;
import br.com.blog.core.domain.repository.CategoryEntity;
import br.com.blog.core.usecase.port.ICategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class CategoryController {

    private final ICategoryUseCase categoryUseCase;
    private final ConverterProvider converterProvider;

    public CategoryController(ICategoryUseCase categoryUseCase, ConverterProvider converterProvider) {
        this.categoryUseCase = categoryUseCase;
        this.converterProvider = converterProvider;
    }


    @PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(
            @RequestBody CategoryRequestDTO request){
        var response = converterProvider.toDomain(request);
        categoryUseCase.createCategory(response);
    }

    @GetMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<CategoryEntity> allCategory(){
        return categoryUseCase.findAllCategory();
    }

    @DeleteMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByIdCategory(@RequestParam Integer id){
        categoryUseCase.deleteByIdCategory(id);
    }
}
