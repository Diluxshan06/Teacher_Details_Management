package com.student.bms.controller;

import com.student.bms.dto.TeacherDto;
import com.student.bms.dto.TeacherSave;
import com.student.bms.dto.TeacherUpdate;
import com.student.bms.entity.Teacher;
import com.student.bms.repo.TeacherRepo;
import com.student.bms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class TeacherControl {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public String saveTeacher(@RequestBody TeacherSave teacherSave){
        String teachername=teacherService.addTeacher(teacherSave);
        return teachername;
    }

    @GetMapping("getall")
    public List<TeacherDto> getTeacher(){
        List<TeacherDto> allTeacher= teacherService.getTeacher();
        return allTeacher;
    }

   @PutMapping("/update")
   public String updateTeacher(@RequestBody TeacherUpdate teacherUpdate){
        String teachername= teacherService.updateTeacher(teacherUpdate);
        return "updated";
   }

   @DeleteMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id") int id){
        boolean deleteTeacher=teacherService.deleteTeacher(id);
        return "deleteteacher";
   }

   @GetMapping("/getbyid/{id}")
    public TeacherDto getById(@PathVariable(value = "id") int id){
        TeacherDto teacherDto=teacherService.getTeahcerById(id);
        return teacherDto;
   }

}
