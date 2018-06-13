package com.fpoly.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Student2 {
    @NotBlank(message = "Không được để trống họ và tên !")
    private String name;

    @NotNull(message = "Không được để trống điểm !")
    @DecimalMin(value = "0", message = "Điểm không hợp lệ !")
    @DecimalMax(value = "10", message = "Điểm không hợp lệ !")
    private Double mark;

    @NotNull(message = "Vui lòng chọn chuyên ngành !")
    private String major;

    public Student2() {
    }

    public Student2(String name, Double mark, String major) {
        this.name = name;
        this.mark = mark;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
