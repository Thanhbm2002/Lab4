package main.lab4.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @NotBlank(message = "Vui lòng nhập email")
    @Email(message = "Email không hợp lệ")
    private String id;

    @NotBlank(message = "Vui lòng nhập họ và tên")
    private String fullname;

    @Builder.Default
    private String photo = "photo.png";

    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;

    @NotNull(message = "Vui lòng nhập ngày sinh")
    @Past(message = "Ngày sinh phải trong quá khứ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday;

    @NotNull(message = "Vui lòng nhập lương")
    @Min(value = 1000, message = "Lương phải từ 1000 trở lên")
    private Double salary;

    @Builder.Default
    private Integer level = 0;
}
