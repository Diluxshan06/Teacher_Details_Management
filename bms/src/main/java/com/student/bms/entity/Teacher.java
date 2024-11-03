package com.student.bms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="teacher_id",length = 11)
    private int teacherid;

    @Column(name="tearcher_name",length = 45)
    private String teachername;

    @Column(name="phone",length = 11)
    private String phone;

    //constructor



    public Teacher(int teacherid,String teachername,String phone ){
        this.teacherid=teacherid;
        this.teachername=teachername;
        this.phone=phone;
    }


    public Teacher(String teachername, String phone) {
        this.teachername = teachername;
        this.phone = phone;
    }

    public Teacher() {
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid=" + teacherid +
                ", teachername='" + teachername + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
