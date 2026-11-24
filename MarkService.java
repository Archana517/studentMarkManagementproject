package com.example.markmanagement.service;
import com.example.markmanagement.dto.StudentMarkDTO;
import com.example.markmanagement.entity.StudentMark;
import com.example.markmanagement.exception.ResourceNotFoundException;
import com.example.markmanagement.repository.MarkRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MarkService {
 private final MarkRepository repository;
 public MarkService(MarkRepository repository){this.repository=repository;}
 public StudentMark add(StudentMarkDTO dto){return repository.save(toEntity(dto,new StudentMark()));}
 public List<StudentMark> getAll(){return repository.findAll();}
 public StudentMark getById(Integer id){return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student mark record not found for ID: "+id));}
 public StudentMark update(Integer id,StudentMarkDTO dto){StudentMark mark=getById(id);return repository.save(toEntity(dto,mark));}
 public void delete(Integer id){StudentMark mark=getById(id);repository.delete(mark);}
 public List<StudentMark> byThreshold(Integer minMarks){if(minMarks<0||minMarks>100)throw new IllegalArgumentException("minMarks must be between 0 and 100");return repository.findByMarksGreaterThanEqual(minMarks);}
 public List<StudentMark> bySubject(String subject){if(subject==null||subject.isBlank())throw new IllegalArgumentException("subject must not be blank");return repository.findBySubjectIgnoreCase(subject.trim());}
 public List<StudentMark> top(int limit){if(limit<1||limit>100)throw new IllegalArgumentException("limit must be between 1 and 100");return repository.findTopNByOrderByMarksDesc(PageRequest.of(0,limit));}
 private StudentMark toEntity(StudentMarkDTO dto,StudentMark mark){mark.setStudentName(dto.getStudentName().trim());mark.setSubject(dto.getSubject().trim());mark.setMarks(dto.getMarks());mark.setExamDate(dto.getExamDate());return mark;}
}
