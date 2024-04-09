package org.example.mongorestapi.dto.master;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionsDto {
    @Id
    private String questionId;
};
