package com.example.markmanagement.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "StudentMarks")
public class StudentMark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID") private Integer studentId;
    @Column(name = "StudentName", nullable = false, length = 100) private String studentName;
    @Column(name = "Subject", nullable = false, length = 50) private String subject;
    @Column(name = "Marks", nullable = false) private Integer marks;
    @Column(name = "ExamDate", nullable = false) private LocalDate examDate;
    public StudentMark() {}
    public StudentMark(String studentName, String subject, Integer marks, LocalDate examDate) { this.studentName=studentName; this.subject=subject; this.marks=marks; this.examDate=examDate; }
    public Integer getStudentId(){return studentId;} public void setStudentId(Integer studentId){this.studentId=studentId;}
    public String getStudentName(){return studentName;} public void setStudentName(String studentName){this.studentName=studentName;}
    public String getSubject(){return subject;} public void setSubject(String subject){this.subject=subject;}
    public Integer getMarks(){return marks;} public void setMarks(Integer marks){this.marks=marks;}
    public LocalDate getExamDate(){return examDate;} public void setExamDate(LocalDate examDate){this.examDate=examDate;}
}
