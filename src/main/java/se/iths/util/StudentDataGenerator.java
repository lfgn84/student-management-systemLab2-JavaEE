package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
@Startup
public class StudentDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        Teacher teacher = new Teacher("Bill", "Gates", "Microsoft@google.com", "555-1234");
        Teacher teacher1 = new Teacher("Martin","Blomberg", "martin@javamaster.se", "555-7698");

        Subject subject = new Subject("Java",teacher1);
        Subject subject1 = new Subject("SpringBoot", teacher1);
        Subject subject2 = new Subject("C-Sharp",teacher);
        Subject subject3 = new Subject("Azure",teacher);


        Student[] students = new Student[6];

        students[0]=new Student("Luis", "Gutierrez", "luis@google.com", "555-2343");
        students[1]=new Student("Erick", "Gutierrez", "erick@google.com", "555-2673");
        students[2]=new Student("Nicklas", "Johansson", "nicklas@google.com", "555-7596");
        students[3]=new Student("Lennart", "Johansson", "lennart@google.com", "555-9867");
        students[4]=new Student("Rob", "Sam", "rob@google.com", "555-3639");
        students[5]=new Student("Daniel", "Van Rankin", "daniel@google.com", "555-1086");

        students[0].addSubject(subject);
        students[0].addSubject(subject1);
        students[1].addSubject(subject2);
        students[1].addSubject(subject3);
        students[2].addSubject(subject);
        students[2].addSubject(subject1);
        students[3].addSubject(subject2);
        students[3].addSubject(subject3);
        students[4].addSubject(subject);
        students[4].addSubject(subject3);
        students[5].addSubject(subject2);
        students[5].addSubject(subject3);


        entityManager.persist(teacher);
        entityManager.persist(teacher1);

        entityManager.persist(students[0]);
        entityManager.persist(students[1]);
        entityManager.persist(students[3]);
        entityManager.persist(students[4]);
        entityManager.persist(students[5]);


    }


}