package com.spring.boot.all;

import com.spring.boot.all.doa.StudentRepository;
import com.spring.boot.all.entity.Guardian;
import com.spring.boot.all.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudentDetails(){
        Student student = Student.builder()
                .name("Pranali")
                .email("ppk@khavle.com")
                .guardian(guardiansDetail())
                .build();
        Student std = studentRepository.save(student);
        System.out.println("Student saved successfully!! "+std);
    }

    private  Guardian guardiansDetail() {
        return Guardian.builder()
                .name("Mrs. Preeti Khawale")
                .mobile(9921253515L)
                .build();
    }
}
