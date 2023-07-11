package com.example.stuber.services;

import com.example.stuber.models.Parent;
import com.example.stuber.models.Student;
import com.example.stuber.repository.Studentrepository;
import com.example.stuber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	Studentrepository studentrepository;
	@Autowired
	UserRepository userrepository;
	@Override
	public List<Student> getstudents() {
		return studentrepository.findAll();
	}

	@Override
	public ResponseEntity<Object> addstudent(Student student) {
		Optional<Parent> optionalParent = userrepository.findParentById((long)student.getParent().getId());
		if (!optionalParent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Parent parent = optionalParent.get();
		student.setParent(parent);
		Student savedStudent = studentrepository.save(student);
		return ResponseEntity.ok(savedStudent);
	}

	@Override
	public List<Student> getStudentByParentId(long id) {
		return studentrepository.findStudentByParentId(id);
	}



}
