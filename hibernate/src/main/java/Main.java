import com.codersait.repository.StudentRepository;
import com.codersait.repository.StudentRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepositoryImpl();
        // studentRepository.update();
        // studentRepository.save();
        // studentRepository.delete();
        // studentRepository.findAll().forEach(student -> System.out.println(student.getFirstName()));

    }
}
