package com.spring.boot.all;

import com.spring.boot.all.doa.StudentRepository;
import com.spring.boot.all.entity.Guardian;
import com.spring.boot.all.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Disabled
    public void saveStudentDetails() {
        Student student = Student.builder()
                .name("Rugved")
                .email("entrepreneur@owner.com")
                .guardian(guardiansDetail())
                .build();
        Student std = studentRepository.save(student);
        System.out.println("Student saved successfully!! " + std);
    }

    private Guardian guardiansDetail() {
        return Guardian.builder()
                .name("Mrs. Shalini Dhamurde")
                .mobile(9764804988L)
                .build();
    }

    @Test
    public void getStudentByName() {
        Student findByName = studentRepository.findByGuardianName("Mrs. Shalini Dhamurde");
        Student findByStudentName = studentRepository.findStudentByName("Samrudhi");
        Student byEmailAddress = studentRepository.findStudentByEmail("ppk@khavle.com");

        System.out.println("Find by Guardian name :" + findByName);
        System.out.println("Find by Student Name :" + findByStudentName);
        System.out.println("Find by  email address :" + byEmailAddress);
    }

    @Test
    public void getAllStudents() {
        System.out.println("------ All Students ----------------");
        studentRepository.findAll().stream().forEach(System.out::println);
    }

    @Test
    public void getStudentByJpql() {
        Student student = studentRepository.findStudentByEmailJpql("ppk@khavle.com");
        System.out.println("jpql query: " + student);
    }

    @Test
    public void getStudentByNamedParam() {
        Student student = studentRepository.getStudentByNamedParam("Vedanti");
        System.out.println("named query: " + student);
    }

 /*   @Test
    public void mustUpdateStudentDetails() {
        String studentName = "Pranali";
        String emailId = "creativemind@futudre.com";
        Student student = studentRepository.updateStudentByName(studentName, emailId);
        System.out.println("Native Query: " + student);
    }*/

}
