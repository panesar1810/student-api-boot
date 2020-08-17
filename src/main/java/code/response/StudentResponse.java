package code.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.entity.Student;
import code.service.StudentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentResponse {
	
	private final StudentService studentService;
	
	@GetMapping
	private ResponseEntity<?> getStudents() {
		return new ResponseEntity<List<Student>>(this.studentService.fetchAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getStudentById(@PathVariable long id) {
		return new ResponseEntity<Student>(this.studentService.fetch(id),HttpStatus.OK);
	}
	
	@PostMapping
	private ResponseEntity<?> addStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(this.studentService.insert(student), HttpStatus.OK);
	}
	
	@PutMapping
	private ResponseEntity<?> updateStudent(@RequestBody Student student) {
		if (null == student.getStudentId()) {
			return new ResponseEntity<String>("Student ID Required", HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<Student>(this.studentService.update(student), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id) {
		if (this.studentService.delete(id)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Student not found", HttpStatus.NOT_FOUND);
	}
	
}
