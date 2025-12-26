// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;
// import org.springframework.http.*;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.web.bind.annotation.*;

// @RestController
// public class AuthController {

//     private final UserService userService;
//     private final AuthenticationManager authManager;
//     private final JwtUtil jwtUtil;

//     public AuthController(UserService userService,
//                           AuthenticationManager authManager,
//                           JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.authManager = authManager;
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
//         User u = userService.findByEmail(req.getEmail());
//         String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
//         return ResponseEntity.ok(new AuthResponse(token));
//     }

//     @PostMapping("/register")
//     public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
//         User u = new User();
//         u.setFullName(req.getFullName());
//         u.setEmail(req.getEmail());
//         u.setPassword(req.getPassword());
//         User saved = userService.registerUser(u);
//         String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
//         return ResponseEntity.ok(new AuthResponse(token));
//     }
// }
// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;

// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody RegisterRequest request) {
//         User user = new User();
//         user.setFullName(request.getFullName());
//         user.setEmail(request.getEmail());
//         user.setPassword(request.getPassword());
//         user.setRole(request.getRole());
//         return userService.registerUser(user);
//     }

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {
//         User user = userService.findByEmail(request.getEmail());

//         if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         String token = jwtUtil.createToken(user.getId(), user.getEmail(), user.getRole());
//         return new AuthResponse(token, user.getRole(), user.getEmail());
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // 👈 COMMON BASE PATH UPDATED HERE
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // LOGIN: POST /auth/login
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        User u = userService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    // REGISTER: POST /auth/register
    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest req) {

        User saved = userService.registerUser(
            new User(null, req.getFullName(), req.getEmail(), req.getPassword(), "MONITOR")
        );

        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
