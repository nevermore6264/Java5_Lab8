package com.fpoly.controller;

import com.fpoly.model.Student1;
import com.fpoly.model.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ValidationController {

    @RequestMapping(value = "form1", method = RequestMethod.GET)
    public String form1(ModelMap model) {
        model.addAttribute("student", new Student1());
        return "validation/form1";
    }

    @RequestMapping(value = "form1", method = RequestMethod.POST)
    public String validate1(ModelMap model,
                            @ModelAttribute("student") Student1 student, BindingResult errors) {
        if (student.getName().trim().length() == 0) {
            errors.rejectValue("name", "student", "Vui lòng nhập họ tên !");
        }
        if (student.getMark() == null) {
            errors.rejectValue("mark", "student", "Vui lòng nhập điểm !");
        } else if (student.getMark() < 0 || student.getMark() > 10) {
            errors.rejectValue("mark", "student", "Điểm không hợp lệ  !");
        }
        if (student.getMajor() == null) {
            errors.rejectValue("major", "student", "Vui lòng chọn một chuyên ngành !");
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
        }
        return "validation/form1";
    }

    @RequestMapping(value = "form2", method = RequestMethod.GET)
    public String form2(ModelMap model) {
        model.addAttribute("student", new Student2());
        return "validation/form2";
    }

    @RequestMapping(value = "form2", method = RequestMethod.POST)
    public String validate2(ModelMap model,
                            @Validated @ModelAttribute("student") Student2 student, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
        } else {
            model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
        }
        return "validation/form2";
    }
}
