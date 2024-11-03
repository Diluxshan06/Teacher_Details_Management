package com.student.bms.service;

import com.student.bms.dto.TeacherDto;
import com.student.bms.dto.TeacherSave;
import com.student.bms.dto.TeacherUpdate;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSave teacherSave);

    List<TeacherDto> getTeacher();

    String updateTeacher(TeacherUpdate teacherUpdate);


    boolean deleteTeacher(int id);

    TeacherDto getTeahcerById(int id);
}
