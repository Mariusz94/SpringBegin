package pl.lyszczarzmariusz.SpringBegin.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterForm {
    @Size(min = 3, max = 19)
    private String login;
    @Pattern(regexp = "[a-z]+")
    private String password;
    @Pattern(regexp = "[a-z]+")
    private String repeatPassword;
    @Email(regexp = "[a-z]+@[a-z]+.[a-z]+")
    private String email;
}
