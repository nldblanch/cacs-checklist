package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

class UserTest {

    @Test
    void setUsername_validEmail_shouldSucceed() {
        User user = new User();
        String validEmail = "test@example.com";
        user.setUsername(validEmail);
        assertEquals(validEmail, user.getUsername());
    }

    @Test
    void setUsername_null_shouldThrowException() {
        User user = new User();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> user.setUsername(null)
        );
        assertEquals("Username cannot be null or empty", exception.getMessage());
    }

    @Test
    void setUsername_invalidEmail_shouldThrowException() {
        User user = new User();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> user.setUsername("invalid-email")
        );
        assertEquals("Username must be a valid email address", exception.getMessage());
    }

    @Test
    void setPassword_valid_shouldSucceed() {
        User user = new User();
        user.setPassword("securePass");
        assertEquals("securePass", user.getPassword());
    }

    @Test
    void setPassword_tooShort_shouldThrowException() {
        User user = new User();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> user.setPassword("123")
        );
        assertEquals("Password must be at least 6 characters long.", exception.getMessage());
    }

    @Test
    void setRoles_validList_shouldSucceed() {
        User user = new User();
        var roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        user.setRoles(roles);
        assertEquals(roles, user.getRoles());
    }

    @Test
    void setRoles_null_shouldThrowException() {
        User user = new User();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> user.setRoles(null)
        );
        assertEquals("Roles cannot be null or empty.", exception.getMessage());
    }

    @Test
    void setRoles_emptyList_shouldThrowException() {
        User user = new User();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> user.setRoles(Collections.emptyList())
        );
        assertEquals("Roles cannot be null or empty.", exception.getMessage());
    }

    @Test
    void getAuthorities_shouldReturnGrantedAuthorities() {
        User user = new User();
        user.setRoles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        var authorities = user.getAuthorities();
        assertEquals(2, authorities.size());
        assertTrue(authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER")));
        assertTrue(authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }
}

