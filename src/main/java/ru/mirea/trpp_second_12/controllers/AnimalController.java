package ru.mirea.trpp_second_12.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с животными. */
@Controller("/animal")
public class AnimalController {

    /** Список животных. */
    private final List<Animal> animalList;

    /** Конструктор. */
    public AnimalController() {
        animalList = new CsvToBeanBuilder<Animal>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Animal.class).build().parse();
    }

    /**
     * Получить список животных.
     * @return список животных
     */
    @Get()
    public HttpResponse<List<Animal>> getAnimals() {
        return HttpResponse.ok(animalList);
    }

    /**
     * Найти животного по идентификатору.
     * @param id идентификатор животного
     * @return Животное, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Animal> findById(Long id) {
        Optional<Animal> result = animalList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
