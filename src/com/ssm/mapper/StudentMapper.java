package com.ssm.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Score;
import com.ssm.model.Student;
import com.ssm.vo.StudentScoresVo;

public interface StudentMapper {

	public void update(Student student);
	public StudentScoresVo getScore(int studentid);
	public void updatePwd(Student student);
	
	public List<Student> getStudents();
	public Student getById(@Param("id") int id);
	public void delete(@Param("id") int id);
	public void addStudent(Student student);
}
