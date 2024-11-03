package com.student.bms.service.IMPL;

import com.student.bms.dto.TeacherDto;
import com.student.bms.dto.TeacherSave;
import com.student.bms.dto.TeacherUpdate;
import com.student.bms.entity.Teacher;
import com.student.bms.repo.TeacherRepo;
import com.student.bms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceIMPL implements TeacherService {

        @Autowired
        private TeacherRepo teacherRepo;

        @Override
        public String addTeacher(TeacherSave teacherSave){
            Teacher teacher = new Teacher(
                    teacherSave.getTeachername(),
                    teacherSave.getPhone()
            );
            teacherRepo.save(teacher);

            return teacher.getTeachername();

        }

    @Override
    public List<TeacherDto> getTeacher() {

            List<Teacher> getTeacher= teacherRepo.findAll();
            List<TeacherDto> teacherDtoList=new ArrayList<>();
            for(Teacher teacher:getTeacher){
                TeacherDto teacherDto=new TeacherDto(
                        teacher.getTeacherid(),
                        teacher.getTeachername(),
                        teacher.getPhone()
                );
                teacherDtoList.add(teacherDto);
            }

        return teacherDtoList;
    }

    @Override
    @Deprecated
    public String updateTeacher(TeacherUpdate teacherUpdate) {

            if(teacherRepo.existsById(teacherUpdate.getTeacherid())){
                Teacher teacher=teacherRepo.getById(teacherUpdate.getTeacherid());
                teacher.setTeachername(teacherUpdate.getTeachername());
                teacher.setPhone(teacherUpdate.getPhone());
                teacherRepo.save(teacher);
                return teacher.getTeachername();
            }
            else{
                System.out.println("ID not Exits");
            }
        return "";
    }

    @Override
    public boolean deleteTeacher(int id) {
            if(teacherRepo.existsById(id)){
                teacherRepo.deleteById(id);
                return true;
            }else{
                return false;
            }

    }

    @Override
    public TeacherDto getTeahcerById(int id) {
            if(teacherRepo.existsById(id)){
                Optional<Teacher> teacher=teacherRepo.findById(id);
                TeacherDto teacherDto=new TeacherDto(teacher.get().getTeacherid(),
                        teacher.get().getTeachername(),
                        teacher.get().getPhone());
                return teacherDto;
            }else {
                System.out.println("id not");
                return null;
            }
    }


}

