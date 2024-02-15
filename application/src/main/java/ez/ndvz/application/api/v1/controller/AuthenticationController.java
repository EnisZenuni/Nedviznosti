package ez.ndvz.application.api.v1.controller;

import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignInRequestDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignInResponseDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpRequestDTO;
import ez.ndvz.application.api.v1.dto.authenticationDTOs.SignUpResponseDTO;
import ez.ndvz.application.api.v1.mapper.UserHttpMapper;
import ez.ndvz.ports.spi.AuthenticationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationServicePort authenticationServicePort;
    private final UserHttpMapper mapper;


    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {

        var User = authenticationServicePort.signUp(mapper.toDomain(signUpRequestDTO));
        System.out.println(User.getName() + "+++++++++++++++++++++++++++++++++++++++++");
        var signUpResponse = SignUpResponseDTO.builder()
                .jwt(authenticationServicePort.getToken(User))
                .message(String.format("User %s registered", User.getName()))
                .success(true)
                .build();

        return ResponseEntity.ok(signUpResponse);
    }

    @PostMapping("/signIn")
    public ResponseEntity<SignInResponseDTO> signIn(@RequestBody SignInRequestDTO signInRequestDTO) {
        var User = authenticationServicePort.signIn(mapper.toDomain(signInRequestDTO));

        var signInResponse = SignInResponseDTO.builder()
                .name(User.getName())
                .lastName(User.getLastName())
                .email(User.getEmail())
                .token(authenticationServicePort.getToken(User))
                .build();

        return ResponseEntity.ok(signInResponse);
    }
}
