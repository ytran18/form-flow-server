package org.example.mongorestapi.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "questions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questions {

    @Data
    public static class Answer {
        @Id
        private String _id;
        private String label;
        private String image_url;
        private Number value;
    };

    @Id
    private String _id;
    private String formId;
    private String dap_an;
    private String title;
    private String type_answer;
    private Boolean isRequire;
    private Number question_index;
    private String image_url;
    private List<Answer> answers;

}
