package com.example.demo.module.account;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class changePassword {

    @Size(min = 6, max = 20)
    private String oldPassword;
    @Size(min = 6, max = 20)
    private String newPassword;
}
