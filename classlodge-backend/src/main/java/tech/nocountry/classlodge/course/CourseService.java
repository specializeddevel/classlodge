package tech.nocountry.classlodge.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepository courseRepository;
    @Autowired
    CourseConverter courseConverter;



    public ArrayList<Course> getCourse(){
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public Course saveCourse(Course course){

        return courseRepository.save(course);
    }

    public Course getById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> null);
    }


    public Course updateById(CourseDTO request, Long id){
         Course courseExist = getById(id);
        if(courseExist ==null){
            return null;
        }
        Course courseUpdate = courseConverter.dtoToEntity(request,courseExist);
        courseUpdate.setId(id);
        courseRepository.save(courseUpdate);
        return courseUpdate;
    }



}
