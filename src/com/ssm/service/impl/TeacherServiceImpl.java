package com.ssm.service.impl;

import java.util.List;

import com.ssm.mapper.TeacherMapper;
import com.ssm.model.Course;
import com.ssm.model.Score;
import com.ssm.model.Teacher;
import com.ssm.service.TeacherService;
import com.ssm.vo.ScoresVo;

public class TeacherServiceImpl implements TeacherService {

	private TeacherMapper teacherMapper;
	
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		teacherMapper.addTeacher(teacher);;
	}

	@Override
	public void deleteTeacher(int id) {
		teacherMapper.deleteTeacher(id);
		
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacherMapper.getTeacherById(id);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherMapper.updateTeacher(teacher);
	}

	@Override
	public boolean checkExist(int id) {
		return false;
	}

	@Override
	public List<Teacher> getTeachers() {
		return teacherMapper.getTeachers();
	}

	@Override
	public List<Score> getScoreByTeacherId(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score getScoreByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudentScore(Score score) {
		teacherMapper.updateStudentScore(score);
	}

	@Override
	public void addScore(Score score) {
		teacherMapper.addStudentScore(score);
		
	}

	@Override
	public void updateTeacherPwd(Teacher teacher) {
		teacherMapper.updateTeacherPwd(teacher);
	}

	@Override
	public Integer getCid() {
		return teacherMapper.getCid();
	}

	@Override
	public void saveCourse(Course course) {
		teacherMapper.saveCourse(course);
	}

	@Override
	public void updateCid(Teacher teacher) {
		teacherMapper.updateCid(teacher);
	}

	@Override
	public List<ScoresVo> loadScores(int id) {
		return teacherMapper.loadScores(id);
	}

	@Override
	public Score editStudentScore(int id) {
		return teacherMapper.editStudentScore(id);
	}

	@Override
	public boolean checkScoreOnlyOne(Score score) {
		if (teacherMapper.checkScoreOnlyOne(score)==null) {
			return true;//如果不存在该成绩则返回false
		}else {
			return false;
		}
	}


	
}
