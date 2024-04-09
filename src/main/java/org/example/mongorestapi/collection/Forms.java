package org.example.mongorestapi.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "forms")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forms {

    @Id
    private String _id;
    private String formTitle;
    private String formDescription;
    private String preview_img;
    private Boolean isAvailable;
    private String modified_at;

}
