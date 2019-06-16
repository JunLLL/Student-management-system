package com.ssm.service.impl;

import java.util.List;
import java.util.Set;

import com.ssm.mapper.StudentMapper;
import com.ssm.model.Score;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import com.ssm.vo.StudentScoresVo;

public class StudentServiceImpl implements StudentService {

	private StudentMapper studentMapper ;
	
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public void add(Student student) {
		studentMapper.addStudent(student);
	}

	@Override
	public boolean exists(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getById(int id) {
		return studentMapper.getById(id);
	}

	@Override
	public List<Student> getStudents() {
		return studentMapper.getStudents();
	}

	@Override
	public void update(Student student) {
		studentMapper.update(student);
	}

	@Override
	public void delete(int id) {
		studentMapper.delete(id);
	}

	@Override
	public void updatePwd(Student student) {
		studentMapper.updatePwd(student);

	}

	@Override
	// 获取学生查询个人成绩的视图信息
	public StudentScoresVo getStudentScores(int id) {
		return studentMapper.getScore(id);
	}

	
}
