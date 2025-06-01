package main.lab4.controller;

import jakarta.validation.Valid;
import main.lab4.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffController {

    @GetMapping("/staff/create/form")
    public String showForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên");
        return "/staff-create";
    }

    @PostMapping("/staff/create/save")
    public String handleSubmit(Model model,
                               @Valid @ModelAttribute("staff") Staff staff,
                               Errors errors,
                               @RequestPart("photo_file") MultipartFile photoFile) {

        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Có lỗi xảy ra, vui lòng kiểm tra lại thông tin!");
        } else {
            model.addAttribute("message", "Thêm nhân viên thành công!");
        }

        return "/staff-validate";
    }
}
