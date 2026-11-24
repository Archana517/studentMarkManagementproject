package com.example.markmanagement.controller;
import com.example.markmanagement.dto.StudentMarkDTO;
import com.example.markmanagement.entity.StudentMark;
import com.example.markmanagement.service.MarkService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/v1/marks")
public class MarkController {
 private final MarkService service;
 public MarkController(MarkService service){this.service=service;}
 @PostMapping public ResponseEntity<StudentMark> add(@Valid @RequestBody StudentMarkDTO dto){return ResponseEntity.status(HttpStatus.CREATED).body(service.add(dto));}
 @GetMapping public List<StudentMark> all(){return service.getAll();}
 @GetMapping("/{studentId}") public StudentMark get(@PathVariable Integer studentId){return service.getById(studentId);}
 @PutMapping("/{studentId}") public StudentMark update(@PathVariable Integer studentId,@Valid @RequestBody StudentMarkDTO dto){return service.update(studentId,dto);}
 @DeleteMapping("/{studentId}") public ResponseEntity<Void> delete(@PathVariable Integer studentId){service.delete(studentId);return ResponseEntity.noContent().build();}
 @GetMapping("/reports/threshold") public List<StudentMark> threshold(@RequestParam Integer minMarks){return service.byThreshold(minMarks);}
 @GetMapping("/reports/subject") public List<StudentMark> subject(@RequestParam String subject){return service.bySubject(subject);}
 @GetMapping("/reports/top") public List<StudentMark> top(@RequestParam(defaultValue="5") int limit){return service.top(limit);}
}
