package rmit.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "teachers")
public class Teacher extends AccountDetails {

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Collection<Course> courses;

    public Teacher(int id, String user_name, String password, String profile_picture,Collection<Course> courses) {
        super(id, user_name, password, profile_picture);
        this.courses = courses;
    }

    public Teacher() {}

    public void updateTeacher(Teacher teacher){
        this.courses = teacher.getCourses();
        }
}
