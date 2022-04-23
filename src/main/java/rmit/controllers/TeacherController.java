package rmit.controllers;

import rmit.exceptions.ResourceNotFoundException;
import rmit.models.Course;
import rmit.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmit.repositories.TeacherRepository;
import rmit.service.CourseService;
import rmit.service.TeacherService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //get teacher
    @GetMapping("teachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    //get teacher by id
    @GetMapping("teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(value = "id") int teacher_id)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(teacherService.getTeacherById(teacher_id));
    }

    //save teacher
    @PostMapping("teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    //delete teacher
    @DeleteMapping("teachers/{id}")
    public Map<String, Boolean> deleteTeacher(@PathVariable(value = "id") int teacher_id) throws ResourceNotFoundException{
        teacherService.deleteTeacher(teacher_id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    //update teacher
    @PutMapping("teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable(value = "id") int teacher_id,
                                               @RequestBody Teacher teacherDetail) throws ResourceNotFoundException {
        return ResponseEntity.ok(teacherService.updateTeacher(teacher_id,teacherDetail));
    }

    //get all courses that are currently taught by teacher
    @GetMapping("teacher/{id}/courses")
    public ResponseEntity<Collection<Course>> getTeachingCourse(@PathVariable(value = "id") int teacher_id) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(teacherService.getAllTeachingCourses(teacher_id));
    }

    //create new course and assign to current teacher
    @PostMapping("teacher/{id}/add_course")
    public Course createNewCourse(@PathVariable(value = "id") int teacher_id,@RequestBody Course course)
            throws ResourceNotFoundException {
        Teacher teacher = teacherService.getTeacherById(teacher_id);
        teacher.getCourses().add(course);
        course.setTeacher(teacher);
        return course;
    }





}
