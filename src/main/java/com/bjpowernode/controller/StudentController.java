package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService service;
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv=new ModelAndView();
        String tips="学生"+student.getName()+"添加失败";
        //调用service处理student
        int nums=service.addStudent(student);
        if (nums>0) {
            tips=student.getName()+"同学添加成功！！！";
        }
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        List<Student> students=service.findStudents();
        return students;
    }
}
