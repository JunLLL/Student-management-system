package com.ssm.service;

import java.util.List;

import com.ssm.model.Course;
import com.ssm.model.Score;
import com.ssm.model.Teacher;
//import com.ssm.vo.ScoresVo;
import com.ssm.vo.ScoresVo;

/**
 * 
 * 有关教师管理操作的接口：包括老师对学生成绩录入�?�查询�?�修改操作，管理员对教师的CRUD操作
 * 
 */
public interface TeacherService {
	// 添加教师信息
	public void addTeacher(Teacher teacher);

	// 删除教师信息
	public void deleteTeacher(int id);

	// 通过教工号获取教师信�?
	public Teacher getTeacherById(int id);

	// 修改教师信息
	public void updateTeacher(Teacher teacher);
	
	// 修改教师照片
	public void updateTeacherPhoto(Teacher teacher);

	// 通过教工号验证是否存在该教师的信�?
	public boolean checkExist(int id);
	
	// 通过学号和课程号判断该成绩是否存在
	public boolean checkScoreOnlyOne(Score score);

	// 获取教师信息列表
	public List<Teacher> getTeachers();

	// 通过教师id查询学生成绩列表
	public List<Score> getScoreByTeacherId(int tid);

	// 通过学生id查询学生成绩
	public Score getScoreByid(int id);
	
	// 通过成绩id查询学生成绩
	public Score editStudentScore(int id);

	// 修改学生成绩
	public void updateStudentScore(Score score);

	// 获取视图对象�?�?信息
	public List<ScoresVo> loadScores(int id);

	// 录入学生成绩
	public void addScore(Score score);

	// 修改教师登录密码
	public void updateTeacherPwd(Teacher teacher);
	
	//获取cid
	public Integer getCid();
	
	//保存课程
	public void saveCourse(Course course);
	
	//修改cid
	public void updateCid(Teacher teacher);

}
