package com.ssm.service;

import java.util.List;
import java.util.Set;

import com.ssm.model.Score;
import com.ssm.model.Student;
/*import com.ssh.vo.StudentScoresVo;*/
import com.ssm.vo.StudentScoresVo;

/**
 * 
 * 有关学生信息管理的业务�?�辑处理的接�?
 * 
 */
public interface StudentService {
	// 添加学生信息
	public void add(Student student);

	// 学号是否存在的验�?
	public boolean exists(Student student);

	// 通过id获取学生信息
	public Student getById(int id);

	// 获取学生信息列表
	public List<Student> getStudents();

	// 修改学生信息
	public void update(Student student);

	// 删除学生信息
	public void delete(int id);

	// 修改登录密码
	public void updatePwd(Student student);

	// 获取学生查询个人成绩的视图信�?
	public StudentScoresVo getStudentScores(int id);

}
