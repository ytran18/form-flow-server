package org.example.mongorestapi.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String _id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String avt_url;
    private String created_at;

}
