package com.paralun.app.controller;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailResponse {

    private String message;
    private boolean error;
}
