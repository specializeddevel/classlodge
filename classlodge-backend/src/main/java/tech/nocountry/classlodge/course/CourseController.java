package tech.nocountry.classlodge.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping
    public ArrayList<Course> getCourse(){

        return this.courseService.getCourse();
    }
    @GetMapping(path = "/{id}")
    @Operation(summary = "Obtener un curso por ID", description = "Devuelve los detalles de un curso específico", tags = {"Cursos"})
    @ApiResponse(responseCode = "200", description = "Curso encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Course.class)))
    @ApiResponse(responseCode = "404", description = "Curso no encontrado", content = @Content)
    @Parameter(name = "id", description = "ID del curso", required = true, example = "1")

    public Course getCourseById(@PathVariable Long id){
        return courseService.getById(id);
    }
    @PostMapping

     public Course saveCourse(@RequestBody Course course){

        return this.courseService.saveCourse(course);
    }

    @PutMapping(path="/{id}")
    public Course modifyCourse(@RequestBody CourseDTO dto, @PathVariable("id") Long id){
        return courseService.updateById(dto,id);
    }
}
