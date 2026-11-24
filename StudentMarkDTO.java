package com.example.markmanagement.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public class StudentMarkDTO {
    @NotBlank(message="Student name is required") @Size(max=100,message="Student name must not exceed 100 characters")
    private String studentName;
    @NotBlank(message="Subject is required") @Size(max=50,message="Subject must not exceed 50 characters")
    private String subject;
    @NotNull(message="Marks are required") @Min(value=0,message="Marks must be between 0 and 100") @Max(value=100,message="Marks must be between 0 and 100")
    private Integer marks;
    @NotNull(message="Exam date is required") private LocalDate examDate;
    public String getStudentName(){return studentName;} public void setStudentName(String studentName){this.studentName=studentName;}
    public String getSubject(){return subject;} public void setSubject(String subject){this.subject=subject;}
    public Integer getMarks(){return marks;} public void setMarks(Integer marks){this.marks=marks;}
    public LocalDate getExamDate(){return examDate;} public void setExamDate(LocalDate examDate){this.examDate=examDate;}
}
