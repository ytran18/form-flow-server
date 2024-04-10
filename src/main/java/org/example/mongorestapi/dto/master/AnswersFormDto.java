package org.example.mongorestapi.dto.master;

import lombok.*;
import org.example.mongorestapi.collection.AnswersForm;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnswersFormDto {

    private String _id;
    private List<AnswersForm> documents;

};