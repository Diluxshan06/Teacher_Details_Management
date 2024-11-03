package com.student.bms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherUpdate {
    private int teacherid;

    private String teachername;

    private String phone;
}
