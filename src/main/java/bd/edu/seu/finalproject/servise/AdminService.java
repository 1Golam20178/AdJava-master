package bd.edu.seu.finalproject.servise;
import bd.edu.seu.finalproject.model.Teacher;
import bd.edu.seu.finalproject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final TeacherRepository teacherRepository;

    public AdminService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public int getTotalClasses() {
        // Mocked data; replace with actual logic or query
        return 116;
    }

    public Teacher getTeacherInfo() {
        // Example: Fetching teacher details
        return teacherRepository.findById(1L).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public double getSalary() {
        // Mocked data; replace with actual logic
        return 25000.00;
    }
}
