package com.documentitos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailBodyDto {
    private String email;
    private String content;
    private String subject;
}
