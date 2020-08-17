package code.response;

import java.util.List;

import org.springframework.stereotype.Service;

import code.entity.Student;
import code.repository.StudentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;
	
	public Student insert(Student student) {
		return this.studentRepository.save(student);
	}
	
	public Student update(Student student) {
		return this.studentRepository.save(student);
	}
	
	public Student fetch(Long studentId) {
		return this.studentRepository.findById(studentId).orElse(null);
	}
	
	public List<Student> fetchAll() {
		return this.studentRepository.findAll();
	}
	
	public Boolean delete(Long studentId) {
		if (this.studentRepository.existsById(studentId)) {
			this.studentRepository.deleteById(studentId);	
			return true;
		} else {
			return false;
		}
	}
	
}
