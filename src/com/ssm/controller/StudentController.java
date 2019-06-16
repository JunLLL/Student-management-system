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
import org.springframework.web.servlet.RequestToViewNameTranslator;

import com.ssm.model.Admin;
import com.ssm.model.Score;
import com.ssm.model.Student;
import com.ssm.service.StudentService;
import com.ssm.vo.StudentScoresVo;


@RequestMapping("Student")
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/update")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String update(Student student,@RequestParam(value="file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
	/*	update student Set name=#{name} password=#{password} sex=#{sex} clazz=#{clazz} birthday=#{birthday}
		Where id=#{id}*/
		String message="修改成功";
		if (file!=null&&file.getSize()>0) {
			String filename=file.getOriginalFilename();
			//"image/photo/"+
			if (filename.endsWith(".png")||filename.endsWith(".jpg")) {
				InputStream is=file.getInputStream();
				String photopath="D:/java/student/"+filename;
				OutputStream os=new FileOutputStream(photopath);
				
				byte[] bs=new byte[1024];
				int len=-1;
				while((len=is.read(bs))!=-1) {
					os.write(bs, 0, len);
				}
				System.out.println("上传成功,路径为:"+photopath);
				os.close();
				is.close();
				student.setPhoto(photopath);
				studentService.updatePhoto(student);
			}else {
				message="图片仅支持png和jpg格式";
			}
		}else {
			//message="未选中图片";
		}
		studentService.update(student);
		request.getSession().setAttribute("message",message);
		request.getSession().setAttribute("url","student/updateStudent.jsp");
		request.getSession().setAttribute("student",student);
		
		return "forward:/success.jsp";
		
	}
	
	@RequestMapping("/getScore")
	public String getScore(HttpServletRequest request,HttpServletResponse response) {
		Student student = (Student)request.getSession().getAttribute("student");
		int id =student.getId();
		System.out.println(id);
		//传入一个id到service,service调用mapper执行sql语句查询出该学生的所有成绩,放入该学生的成绩集合内
		StudentScoresVo scoresVo= studentService.getStudentScores(id);
		request.getSession().setAttribute("scoresVo", scoresVo);
		
		
		
		Set<Score> scores=scoresVo.getScores();
		for(Score score:scores) {
			System.out.println(score.getScore()+"||");
		}
		return "student/scoreInfo";
		
	}
	@RequestMapping("/updatePwd")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updatePwd(@RequestParam("id") Integer id,@RequestParam("newPassword") String newPassword) {
		Student student=new Student();
		student.setId(id);
		student.setPassword(newPassword);
		studentService.updatePwd(student);
		return "forward:/logout.jsp";
		
	}
	
	//以下是管理员才能调用的请求方法
	
	@RequestMapping("/listStudent")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String listStudent(HttpServletRequest request) {
		List<Student> students=studentService.getStudents();
		request.getSession().setAttribute("students", students);
		return "behind/studentList";
		
	}
	
	@RequestMapping("/getStudentById")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String getStudentById(@RequestParam Integer id,HttpServletRequest request) {
		Student student=studentService.getById(id);
		if (student==null) {
			request.getSession().setAttribute("message","查无此人");
			request.getSession().setAttribute("url","behind/studentList.jsp");
			
			return "forward:/success.jsp";
		}else {
			request.getSession().setAttribute("student", student);
			return "student/updateStudent";
		}
	}
	
	
	@RequestMapping("/editStudent")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String editStudent(@RequestParam Integer id,HttpServletRequest request) {
		System.out.println(id);
		Student student=studentService.getById(id);
		request.setAttribute("student", student);
		return "behind/editStudent";
		
	}
	
	@RequestMapping("/updateStudent")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updateStudent(Student student,@RequestParam(value="file") MultipartFile file,HttpServletRequest request) throws IOException {
	
		if (file!=null) {
			InputStream is=file.getInputStream();
			String filename=file.getOriginalFilename();
			//"image/photo/"+
			String photopath="D:\\java\\"+filename;
			OutputStream os=new FileOutputStream(photopath);
			
			byte[] bs=new byte[1024];
			int len=-1;
			while((len=is.read(bs))!=-1) {
				os.write(bs, 0, len);
			}
			os.close();
			is.close();
			student.setPhoto(photopath);
		}
		studentService.update(student);
		request.getSession().setAttribute("message","修改成功");
		request.getSession().setAttribute("url","Student/listStudent");
		return "forward:/success.jsp";
		
	}
	
	@RequestMapping("/deleteStudent")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String deleteStudent(@RequestParam int id,HttpServletRequest request) {
		studentService.delete(id);
		request.getSession().setAttribute("message","删除成功");
		request.getSession().setAttribute("url","Student/listStudent");
		return "forward:/success.jsp";
		
	}
	@RequestMapping("/getStudentPwd")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String getStudentPwd(@RequestParam int id,HttpServletRequest request) {
		Student student=studentService.getById(id);
		request.getSession().setAttribute("student",student);
		return "behind/updateStudentPwd";
		
	}
	@RequestMapping("/updateStudentPwd")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String updateStudentPwd(@RequestParam("id") int id,@RequestParam("newPassword") String newPassword,HttpServletRequest request) {
		Student student=new Student();
		student.setId(id);
		student.setPassword(newPassword);
		studentService.updatePwd(student);
		request.getSession().setAttribute("message","修改成功");
		request.getSession().setAttribute("url","Student/listStudent");
		return "forward:/success.jsp";
		
	}
	@RequestMapping("/addStudent")//springmvc可以自动将from表单中传来的name值与对象属性名相等的值,封装为对象
	public String addStudent(Student student,HttpServletRequest request) {
		Student s=studentService.getById(student.getId());
		if (s==null) {
			studentService.add(student);
			request.getSession().setAttribute("message","添加成功");
			request.getSession().setAttribute("url","Student/listStudent");
		}else {
			request.getSession().setAttribute("message","已有该学号学生");
			request.getSession().setAttribute("url","Student/listStudent");
		}
		return "forward:/success.jsp";
	}
	
	@ResponseBody
	@RequestMapping("getPhotoImage")
	public void getPhotoImage(@RequestParam int id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		Student student=studentService.getById(id);
		String photo=student.getPhoto();
		
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
}
