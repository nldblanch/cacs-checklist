package com.v1.cacs_checklist.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String redirectUrl = null;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ADMIN")) {
                redirectUrl = "/admin/dashboard";
            } else if (grantedAuthority.getAuthority().equals("SUBMITTER")) {
                redirectUrl = "/submitter/dashboard";
            } else if (grantedAuthority.getAuthority().equals("ASSESSOR")) {
                redirectUrl = "/assessor/dashboard";
            } else if (grantedAuthority.getAuthority().equals("OWNER")) {
                redirectUrl = "/owner/dashboard";
                break;
            }
        }
        if (redirectUrl == null) {
            throw new IllegalStateException();
        }
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
