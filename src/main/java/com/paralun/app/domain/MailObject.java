package com.paralun.app.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MailObject {
    private String to;
    private String subject;
    private String text;
}
