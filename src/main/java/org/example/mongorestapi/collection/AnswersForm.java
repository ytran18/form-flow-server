package org.example.mongorestapi.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "answers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswersForm {

    @Data
    public static class Assignee {
        private String name;
        private Number cccd;
        private String birthday;
        private String company;
        private String cccd_front_pic;
    };

    @Data
    public static class Answers {
        private String questionId;
        private String type_question;
        private int value;
        private String answerId;
    };

    @Id
    private String _id;
    private String formId;
    private String modified_at;
    private Assignee assignee;
    private List<Answers> answers;

}
