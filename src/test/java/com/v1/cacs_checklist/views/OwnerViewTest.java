package com.v1.cacs_checklist.views;

import com.v1.cacs_checklist.models.User;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.microsoft.playwright.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerViewTest {

    @LocalServerPort
    private int port;

    private static Playwright playwright;
    private static Browser browser;

    private BrowserContext context;
    private Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @BeforeAll
    static void waitForServerStartup() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterAll
    static void closeBrowser() {
        if (playwright != null) {
            playwright.close();
        }
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();

        // Navigate to login page
        page.navigate("http://localhost:" + port + "/login");

        // Fill in credentials (adjust selectors as needed)
        page.fill("#username", "owner1@v1.com");
        page.fill("#password", "password");
        page.click("button[type=submit]");
        page.waitForURL("http://localhost:" + port + "/owner/dashboard");
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void navbarAndLogoutTest() {
        page.navigate("http://localhost:" + port + "/owner/dashboard");

        assertTrue(page.isVisible("nav"), "Navigation bar is missing");

        //logout button
        Locator logoutForm = page.locator("nav form[action='/logout']");
        Locator logoutButton = logoutForm.locator("button.btn-outline-danger");

        assertTrue(logoutForm.isVisible(), "Logout form is missing from the navbar");
        assertTrue(logoutButton.isVisible(), "Logout button is missing inside the form");

        logoutButton.click();
        page.waitForURL("http://localhost:" + port + '/');
        assertTrue(page.isVisible("#username"), "Not redirected to login after logout");

///html/body/div/div/div/ul/li[1]
    }

    @Test
    void DashboardTest() {

        //arrange
        String endpoint = "/owner/dashboard";

        //act
        page.navigate("http://localhost:" + port + endpoint);

        //assert

        //main elements
        assertTrue(page.isVisible("h1"), "Dashboard header is missing");
        assertTrue(page.isVisible("nav"), "Navigation bar is missing");
        assertTrue(page.isVisible("div.container"), "Main content container is missing");

        //heading
        String headerText = page.locator("h1").innerText();
        assertTrue(headerText.contains("Dashboard"), "Dashboard header is incorrect");

        //dashboard components
        assertTrue(page.locator("section h2").nth(0).textContent().matches("Recent Submissions \\(\\d+\\)"), "Non Compliance count is missing or incorrect");
        assertTrue(page.locator("section h2").nth(1).textContent().matches("Non Compliance \\(\\d+\\)"), "Non Compliance count is missing or incorrect");
        assertTrue(page.locator("section h2").nth(2).textContent().matches("Pending Submissions \\(\\d+\\)"), "Pending Submissions count is missing or incorrect");

    }

    @Test
    void ChecklistsTest() {
        //arrange
        String endpoint = "/owner/checklists";

        //act
        page.navigate("http://localhost:" + port + endpoint);

        //assert

        //main elements
        assertTrue(page.isVisible("h1"), "Template header is missing");
        assertTrue(page.isVisible("nav"), "Navigation bar is missing");
        assertTrue(page.isVisible("div.container"), "Main content container is missing");
        assertTrue(page.isVisible("ul"), "Template list is missing");

        //heading
        String headerText = page.locator("h1").innerText();
        assertTrue(headerText.contains("Your Templates"), "Checklists header is incorrect");

        //templates
        Locator templates = page.locator("li.list-group-item a");
        int templateCount = templates.count();

        if (templateCount > 0) {
            // If templates exist, validate name and href format
            String templateName = templates.first().innerText();
            String templateHref = templates.first().getAttribute("href");

            assertFalse(templateName.isEmpty(), "Template name should not be empty");
            assertTrue(templateHref.startsWith("/owner/checklists/"), "Template href is incorrect");
        } else {
            // If no templates exist, ensure list is absent or empty
            assertTrue(page.locator("ul.list-group").isVisible(), "Template list container is missing");
            assertEquals(0, templateCount, "Template list should be empty for some owners");
        }

    }

    @Test
    void clickingTemplateNavigatesCorrectly() {
        page.navigate("http://localhost:" + port + "/owner/checklists");

        // Click on the first template link
        page.locator("li.list-group-item a").first().click();

        // Wait for navigation and confirm new URL structure
        page.waitForURL("http://localhost:" + port + "/owner/checklists/*"); // Wildcard for dynamic ID
    }
}
