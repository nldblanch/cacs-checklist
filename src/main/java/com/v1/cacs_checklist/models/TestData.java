package com.v1.cacs_checklist.models;

import java.time.LocalDate;
import java.util.List;


public class TestData {
    public static List<Checklist> getDummyChecklists() {

        return List.of(
                new Checklist("CL001", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Equipment Maintenance", false, false, LocalDate.of(2025, 5, 10), null,
                        List.of(new Field("Has the generator been serviced?", "No"), new Field("Is the fuel level sufficient?", "Yes")),
                        "Sean", "owner2@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL003", "Workplace Safety", false, false, LocalDate.of(2025, 5, 5), null,
                        List.of(new Field("Are safety gloves provided?", "Yes"), new Field("Is PPE worn at all times?", "No")),
                        "Gurdeep", "owner1@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL004", "Annual Compliance", true, false, LocalDate.of(2025, 4, 28), LocalDate.of(2025, 4, 29),
                        List.of(new Field("Has the document review been completed?", "Yes"), new Field("Are all approvals obtained?", "No")),
                        "Sean", "owner2@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL005", "Data Security Audit", false, false, LocalDate.of(2025, 5, 18), null,
                        List.of(new Field("Are passwords changed regularly?", "Yes"), new Field("Has the backup been verified?", "No")),
                        "Gurdeep", "owner1@v1.com", "Hibbah", "user5@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL006", "Software Update Review", true, true, LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 16),
                        List.of(new Field("Are all systems running the latest updates?", "Yes"), new Field("Has a rollback plan been created?", "No")),
                        "Sean", "owner2@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL007", "Training Compliance", false, false, LocalDate.of(2025, 5, 20), null,
                        List.of(new Field("Have all employees completed training?", "No"), new Field("Are refresher courses scheduled?", "Yes")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL008", "Facilities Inspection", true, false, LocalDate.of(2025, 4, 30), LocalDate.of(2025, 5, 1),
                        List.of(new Field("Is HVAC functioning?", "Yes"), new Field("Are security cameras operational?", "No")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL009", "Office Cleanliness Audit", true, true, LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 21),
                        List.of(new Field("Are workspaces tidy?", "Yes"), new Field("Is trash disposal routine followed?", "No")),
                        "Gurdeep", "owner1@v1.com", "Hibbah", "user5@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL010", "Energy Efficiency Check", false, false, LocalDate.of(2025, 5, 12), null,
                        List.of(new Field("Are unused lights turned off?", "Yes"), new Field("Are appliances running efficiently?", "No")),
                        "Sean", "owner2@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL011", "Cybersecurity Compliance", true, false, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 4, 26),
                        List.of(new Field("Has multi-factor authentication been enabled?", "Yes"), new Field("Are access logs monitored regularly?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL012", "Environmental Audit", false, false, LocalDate.of(2025, 5, 25), null,
                        List.of(new Field("Is recycling being properly sorted?", "No"), new Field("Are green initiatives in place?", "Yes")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL013", "Emergency Drill Evaluation", false, false, LocalDate.of(2025, 5, 30), null,
                        List.of(new Field("Were evacuation procedures followed correctly?", "Yes"), new Field("Did all employees participate?", "No")),
                        "Gurdeep", "owner1@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL014", "Workplace Diversity Review", true, true, LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 11),
                        List.of(new Field("Are hiring practices inclusive?", "Yes"), new Field("Are diversity training programs effective?", "No")),
                        "Sean", "owner2@v1.com", "Hibbah", "user5@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL015", "Fire Safety Evaluation", false, false, LocalDate.of(2025, 5, 28), null,
                        List.of(new Field("Are fire extinguishers easily accessible?", "Yes"), new Field("Are evacuation routes clearly marked?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL016", "Supplier Quality Assessment", true, false, LocalDate.of(2025, 4, 17), LocalDate.of(2025, 4, 18),
                        List.of(new Field("Do suppliers meet expected quality standards?", "Yes"), new Field("Are supply chains regularly reviewed?", "No")),
                        "Sean", "owner2@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")
        );
    }
}
