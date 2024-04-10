package org.example.mongorestapi.dto.master;

import lombok.*;
import org.example.mongorestapi.collection.Questions;
import org.springframework.data.annotation.Id;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FormsDto {

    @Id
    private String _id;
    private String formTitle;
    private String formDescription;
    private String preview_img;
    private Boolean isAvailable;
    private String modified_at;
    private List<Questions> questions;

}
