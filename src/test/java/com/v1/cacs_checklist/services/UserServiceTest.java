package com.v1.cacs_checklist.services;

import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = mock(UserRepository.class);
        userService = new UserService();
        // Use reflection to inject the mock manually since there's no constructor
        try {
            var field = UserService.class.getDeclaredField("userRepository");
            field.setAccessible(true);
            field.set(userService, userRepository);
        } catch (Exception e) {
            fail("Could not inject mock UserRepository");
        }
    }

    @Test
    void loadUserByUsername_validUser_shouldReturnUser() {
        User user = new User("test@example.com", "password", true, List.of("ROLE_USER"), "Test User");
        when(userRepository.findByUsername("test@example.com")).thenReturn(Optional.of(user));

        var result = userService.loadUserByUsername("test@example.com");

        assertEquals(user, result);
    }

    @Test
    void loadUserByUsername_userNotFound_shouldThrowException() {
        when(userRepository.findByUsername("missing@example.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class,
                () -> userService.loadUserByUsername("missing@example.com"));
    }

    @Test
    void getLoggedInUser_shouldReturnAuthenticatedUser() {
        User user = new User("auth@example.com", "password", true, List.of("ROLE_USER"), "Authenticated User");

        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(user);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(auth);

        try (MockedStatic<SecurityContextHolder> contextHolderMock = mockStatic(SecurityContextHolder.class)) {
            contextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            User result = UserService.getLoggedInUser();
            assertEquals(user, result);
        }
    }

    @Test
    void getLoggedInUser_nullAuthentication_shouldReturnNull() {
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(null);

        try (MockedStatic<SecurityContextHolder> contextHolderMock = mockStatic(SecurityContextHolder.class)) {
            contextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            assertNull(UserService.getLoggedInUser());
        }
    }

    @Test
    void getLoggedInUser_invalidPrincipal_shouldReturnNull() {
        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn("someString");

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(auth);

        try (MockedStatic<SecurityContextHolder> contextHolderMock = mockStatic(SecurityContextHolder.class)) {
            contextHolderMock.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            assertNull(UserService.getLoggedInUser());
        }
    }
}

