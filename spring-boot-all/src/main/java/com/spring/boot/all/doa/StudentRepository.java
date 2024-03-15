package com.spring.boot.all.doa;

import com.spring.boot.all.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByGuardianName(String guardianName);

    Student findStudentByName(String studentName);

    Student findStudentByEmail(String email);

    @Query(value = "Select s from Student s where s.email = ?1")
    Student findStudentByEmailJpql(String mail);

    @Query(value = "Select s from Student s where s.name = :studentName")
    Student getStudentByNamedParam(@Param("studentName") String studentName);

/*    @Modifying
    @Transactional
    @Query(
            value = " update student s SET s.email_address = ?2 where s.student_name = ?1",
            nativeQuery = true
    )
    Student updateStudentByName(String name, String mail);*/
}
