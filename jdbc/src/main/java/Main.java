import com.codersait.model.Student;
import com.codersait.repository.StudentRepository;
import com.codersait.repository.StudentRepositoryImpl;
import com.codersait.service.StudentService;
import com.codersait.service.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        //studentService.delete(2);
        //studentService.add(new Student("cimsit","cura","cimsit@mail",55));
        //studentService.update(9,new Student("ariza","fatma","sss@mail",99));
        //studentService.getAll().forEach(student -> System.out.println(student));
        System.out.println(studentService.getById(8));
        //studentService.getById(8);
    }
}
