package com.ssm.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssm.model.Course;
import com.ssm.model.Score;
import com.ssm.model.Student;
import com.ssm.model.Teacher;
import com.ssm.service.TeacherService;
import com.ssm.vo.ScoresVo;
import com.ssm.vo.StudentScoresVo;


@RequestMapping("Teacher")
@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@RequestMapping("/update")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String update(Teacher teacher,@RequestParam(value="file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
		String message="修改成功";
		if (file!=null&&file.getSize()>0) {
			String filename=file.getOriginalFilename();
			//"image/photo/"+
			if (filename.endsWith(".png")||filename.endsWith(".jpg")) {
				InputStream is=file.getInputStream();
				String photopath="D:/java/teacher/"+filename;
				OutputStream os=new FileOutputStream(photopath);
				
				byte[] bs=new byte[1024];
				int len=-1;
				while((len=is.read(bs))!=-1) {
					os.write(bs, 0, len);
				}
				System.out.println("上传成功,路径为:"+photopath);
				os.close();
				is.close();
				teacher.setPhoto(photopath);
				teacherService.updateTeacherPhoto(teacher);
			}else {
				message="图片仅支持png和jpg格式";
			}
		}else {
			//message="未选中图片";
		}
		
		teacherService.updateTeacher(teacher);
		request.getSession().setAttribute("message",message);
		request.getSession().setAttribute("url","teacher/updateTeacher.jsp");
		request.getSession().setAttribute("teacher",teacher);
		
		return "forward:/success.jsp";
		
	}
	@RequestMapping("/loadStudentScores")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String loadStudentScores(HttpServletRequest request,HttpServletResponse response) {
		/*	update student Set name=#{name} password=#{password} sex=#{sex} clazz=#{clazz} birthday=#{birthday}
		Where id=#{id}*/
		Teacher teacher=(Teacher)request.getSession().getAttribute("teacher");
		System.out.println(teacher.getId());
		List<ScoresVo> scoresList=teacherService.loadScores(teacher.getCourse().getId());
		request.getSession().setAttribute("scoresList",scoresList);
		return "teacher/scoresInfo";
		
	}
	
	@RequestMapping("/editStudentScore")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String editStudentScore(@RequestParam Integer id,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(id);
		Score score=teacherService.editStudentScore(id);
		request.setAttribute("score",score);
		return "teacher/editScore";
		
	}
	@RequestMapping("/updateStudentScore")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updateStudentScore(Score score,HttpServletRequest request,HttpServletResponse response) {
		/*	update student Set name=#{name} password=#{password} sex=#{sex} clazz=#{clazz} birthday=#{birthday}
		Where id=#{id}*/
		System.out.println(score.getScore());
		
		teacherService.updateStudentScore(score);
		request.getSession().setAttribute("message","修改成功");
		request.getSession().setAttribute("url","Teacher/loadStudentScores");
		return "forward:/success.jsp";
		
	}
	
	//一个学生的一个课程只能有一个成绩
	@RequestMapping("/addStudentScore")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String addStudentScore(Score score,HttpServletRequest request,HttpServletResponse response) {
		
		//先判断是否有该学生成绩
		
		try {
			if (teacherService.checkScoreOnlyOne(score)) {
				System.out.println(score.getStudent().getId()+"||"+score.getCourse().getId());
				teacherService.addScore(score);
				return "teacher/success";
			}else {
				request.getSession().setAttribute("message","添加失败,该学生该课程已有成绩!");
				request.getSession().setAttribute("url","Teacher/loadStudentScores");
				return "forward:/success.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/error.jsp";
		
	}
	
	@RequestMapping("/listTeacher")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String listTeacher(HttpServletRequest request) {
		List<Teacher> teachers=teacherService.getTeachers();
		request.getSession().setAttribute("teachers", teachers);
		return "behind/teacherList";
		
	}
	@RequestMapping("/getTeacherById")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String getTeacherById(@RequestParam Integer id,HttpServletRequest request) {
		Teacher teacher=teacherService.getTeacherById(id);
		if (teacher==null) {
			request.getSession().setAttribute("message","查无此人");
			request.getSession().setAttribute("url","behind/studentList.jsp");
			
			return "forward:/success.jsp";
		}else {
			request.getSession().setAttribute("teacher", teacher);
			return "teacher/updateTeacher";
		}
		
	}
	
	@RequestMapping("/editTeacher")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String editTeacher(@RequestParam Integer id,HttpServletRequest request) {
		Teacher teacher=teacherService.getTeacherById(id);
		request.setAttribute("teacher", teacher);
		return "behind/editTeacher";
		
	}
	
	@RequestMapping("/updateTeacher")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updateTeacher(Teacher teacher,HttpServletRequest request) {
		teacherService.updateTeacher(teacher);
		request.getSession().setAttribute("message","修改成功");
		request.getSession().setAttribute("url","Teacher/listTeacher");
		return "forward:/success.jsp";
		
	}
	
	@RequestMapping("/deleteTeacher")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String deleteTeacher(@RequestParam Integer id,HttpServletRequest request) {
		teacherService.deleteTeacher(id);
		request.getSession().setAttribute("message","删除成功");
		request.getSession().setAttribute("url","Teacher/listTeacher");
		return "forward:/success.jsp";
		
	}
	
	@RequestMapping("/getTeacherPwd")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String getTeacherPwd(@RequestParam Integer id,HttpServletRequest request) {
		Teacher teacher=teacherService.getTeacherById(id);
		request.getSession().setAttribute("teacher",teacher);
		return "behind/updateTeacherPwd";
		
	}
	
	@RequestMapping("/updateTeacherPwd")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updateTeacherPwd(Teacher teacher,HttpServletRequest request) {
		teacherService.updateTeacherPwd(teacher);
		request.getSession().setAttribute("message","修改成功");
		request.getSession().setAttribute("url","Teacher/listTeacher");
		return "forward:/success.jsp";
		
	}
	
	//如何实现?先插入一条教师数据,course_id为空,再根据教师教工号插入一条课程数据,将该课程的自增长id返回回来再update教师表的course_id字段
	@RequestMapping("/addTeacher")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String addTeacher(Teacher teacher,HttpServletRequest request) {
		//Teacher t=teacherService.getTeacherById(teacher.getId());
		String cname=teacher.getCourse().getName();
		System.out.println(cname);
		if (teacherService.getTeacherById(teacher.getId())==null) {//不存在该教师可以执行添加
			teacherService.addTeacher(teacher);//插入教师
			
			int i=teacherService.getCid();
			Course course=new Course();
			course.setId(i+1);//最大值加一即为插入的课程号的id
			course.setName(cname);//获取课程表需要的字段封装在对象中
			course.setTeacher(teacher);
			teacherService.saveCourse(course);
			
			teacher.setCourse(course);
			teacherService.updateCid(teacher);
			
			request.getSession().setAttribute("message","添加成功");
			request.getSession().setAttribute("url","Teacher/listTeacher");
		}else {
			request.getSession().setAttribute("message","已有该教工号教师");
			request.getSession().setAttribute("url","Teacher/listTeacher");
		}
		return "forward:/success.jsp";
		
	}
	
	@ResponseBody
	@RequestMapping("getPhotoImage")
	public void getPhotoImage(@RequestParam int id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		Teacher teacher=teacherService.getTeacherById(id);
		String photo=teacher.getPhoto();
		
		if (photo==null) {
			photo="D:/java/default/person.png";
		}
		InputStream is=new FileInputStream(photo);
		OutputStream os=response.getOutputStream();
		byte[] bs=new byte[1024];
		int len=-1;
		while((len=is.read(bs))!=-1) {
			os.write(bs, 0, len);
		}
		os.close();
		is.close();
		
	}
	
	
	
	//==========
	
}
