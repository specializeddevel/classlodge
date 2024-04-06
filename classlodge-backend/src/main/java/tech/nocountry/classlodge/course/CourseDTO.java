package tech.nocountry.classlodge.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String name;
    private String description;

    private Integer total_hours;

    private Double price;

    private CurrencyEnum currency;


    private CategoryEnum category;


    private String thumbnail_url;

    private Boolean is_published;

    private Boolean has_certification;

}
