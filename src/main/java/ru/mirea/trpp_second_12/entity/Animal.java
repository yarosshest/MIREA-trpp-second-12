package ru.mirea.trpp_second_12.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/** Сущность животного. */
@Getter
@Setter
@ToString
public class Animal {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Название. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** Имя вида научной классификации. */
    @JsonProperty("scientificName")
    @CsvBindByName(column = "scientific_name")
    private String scientificName;
    /** Продолжительность жизни. */
    @JsonProperty("lifeTime")
    @CsvBindByName(column = "life_time")
    private BigDecimal lifeTime;

}
