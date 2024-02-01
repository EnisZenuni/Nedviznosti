package ez.ndvz.application.api.v1.controller;

import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpRequestDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpResponseDTO;
import ez.ndvz.ports.api.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")

public class AuthenticationController {
    private final UserServicePort userServicePort;

    @Autowired
    public AuthenticationController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
        return null;
    }
}
