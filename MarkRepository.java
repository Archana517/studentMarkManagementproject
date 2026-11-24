package com.example.markmanagement.repository;
import com.example.markmanagement.entity.StudentMark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface MarkRepository extends JpaRepository<StudentMark, Integer> {
    List<StudentMark> findByMarksGreaterThanEqual(Integer minMarks);
    List<StudentMark> findBySubjectIgnoreCase(String subject);
    @Query("select m from StudentMark m order by m.marks desc, m.studentName asc")
    List<StudentMark> findTopNByOrderByMarksDesc(Pageable pageable);
}
