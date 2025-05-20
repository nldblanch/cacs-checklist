package com.v1.cacs_checklist.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.repositories.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Component
@Profile("ci")
public class DatabaseSeed implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseSeed(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            List<User> users = List.of(
                    new User("user1@v1.com", passwordEncoder.encode("password"), true, List.of("SUBMITTER"), "Nathan"),
                    new User("user2@v1.com", passwordEncoder.encode("password"), true, List.of("SUBMITTER"), "Anees"),
                    new User("user3@v1.com", passwordEncoder.encode("password"), true, List.of("SUBMITTER"), "Albert"),
                    new User("user4@v1.com", passwordEncoder.encode("password"), true, List.of("SUBMITTER"), "Barak"),
                    new User("user5@v1.com", passwordEncoder.encode("password"), true, List.of("SUBMITTER"), "Hibbah"),
                    new User("owner1@v1.com", passwordEncoder.encode("password"), true, List.of("OWNER"), "Gurdeep"),
                    new User("owner2@v1.com", passwordEncoder.encode("password"), true, List.of("OWNER"), "Sean"),
                    new User("assessor@v1.com", passwordEncoder.encode("password"), true, List.of("ASSESSOR"), "Alex"),
                    new User("admin@v1.com", passwordEncoder.encode("password"), true, List.of("ADMIN"), "Charlie"),
                    new User("demo@v1.com", passwordEncoder.encode("password"), true, List.of("ADMIN", "SUBMITTER", "OWNER", "ASSESSOR"), "Sam"),
                    new User("dualuser@v1.com", passwordEncoder.encode("password"), true, List.of("OWNER", "SUBMITTER"), "Dominika")
            );

            userRepository.saveAll(users);
            System.out.println("✅ Database seeding completed in CI!");
        }
    }
}

