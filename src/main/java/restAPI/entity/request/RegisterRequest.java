package restAPI.entity.request;

import lombok.Data;

@Data
public class RegisterRequest {
    String userName;
    String password;
}

