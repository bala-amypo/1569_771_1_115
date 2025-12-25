@Component
public class JwtUtil {

    private final String secret;
    private final int expiryMinutes;

    public JwtUtil(String secret, int expiryMinutes) {
        this.secret = secret;
        this.expiryMinutes = expiryMinutes;
    }

    public String generateToken(Long userId, String email, String role) {
        return userId + "|" + email + "|" + role;
    }

    public String extractEmail(String token) {
        return token.split("\\|")[1];
    }

    public String extractRole(String token) {
        return token.split("\\|")[2];
    }

    public Long extractUserId(String token) {
        return Long.parseLong(token.split("\\|")[0]);
    }

    public boolean validateToken(String token) {
        return token != null && token.split("\\|").length == 3;
    }
}
