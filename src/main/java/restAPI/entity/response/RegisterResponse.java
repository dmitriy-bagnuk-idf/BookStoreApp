package restAPI.entity.response;

import lombok.Data;

import java.util.List;

@Data
public class RegisterResponse {
    String userID;
    String username;
    List<String> books;
}
