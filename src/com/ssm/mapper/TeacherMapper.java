package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Course;
import com.ssm.model.Score;
import com.ssm.model.Student;
import com.ssm.model.Teacher;
import com.ssm.vo.ScoresVo;

public interface TeacherMapper {

	public void updateTeacher(Teacher teacher);
	public List<ScoresVo> loadScores(@Param("id") Integer id);
	public Score editStudentScore(@Param("id") Integer id);
	public void updateStudentScore(Score score);
	public void addStudentScore(Score score);
	public Score checkScoreOnlyOne(Score score);
	
	public List<Teacher> getTeachers();
	public Teacher getTeacherById(@Param("id") int id);
	public void deleteTeacher(@Param("id") int id);
	public void updateTeacherPwd(Teacher teacher);
	public void addTeacher(Teacher teacher);
	public Integer getCid();
	public void saveCourse(Course course);
	public void updateCid(Teacher teacher);
}
