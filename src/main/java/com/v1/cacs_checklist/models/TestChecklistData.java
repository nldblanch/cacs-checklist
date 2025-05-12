package com.v1.cacs_checklist.models;

import java.time.LocalDate;
import java.util.List;


public class TestChecklistData {
    public static List<Template> getDummyTemplates() {
        return List.of(
                new Template(
                        "Temp1",
                        "Safety Inspection",
                        List.of(
                                new Template.Fieldset("Are fire exits accessible?", "String", true),
                                new Template.Fieldset("Are emergency lights working?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp2",
                        "Equipment Maintenance",
                        List.of(
                                new Template.Fieldset("Has the generator been serviced?", "String", true),
                                new Template.Fieldset("Is the fuel level sufficient?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp3",
                        "Data Security Audit",
                        List.of(
                                new Template.Fieldset("Are passwords changed regularly?", "String", true),
                                new Template.Fieldset("Has the backup been verified?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp4",
                        "Software Update Review",
                        List.of(
                                new Template.Fieldset("Are all systems running the latest updates?", "String", true),
                                new Template.Fieldset("Has a rollback plan been created?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp5",
                        "Training Compliance",
                        List.of(
                                new Template.Fieldset("Have all employees completed training?", "String", true),
                                new Template.Fieldset("Are refresher courses scheduled?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp6",
                        "Facilities Inspection",
                        List.of(
                                new Template.Fieldset("Is HVAC functioning?", "String", true),
                                new Template.Fieldset("Are security cameras operational?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp7",
                        "Office Cleanliness Audit",
                        List.of(
                                new Template.Fieldset("Are workspaces tidy?", "String", true),
                                new Template.Fieldset("Is trash disposal routine followed?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp8",
                        "Energy Efficiency Check",
                        List.of(
                                new Template.Fieldset("Are unused lights turned off?", "String", true),
                                new Template.Fieldset("Are appliances running efficiently?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp9",
                        "Cybersecurity Compliance",
                        List.of(
                                new Template.Fieldset("Has multi-factor authentication been enabled?", "String", true),
                                new Template.Fieldset("Are access logs monitored regularly?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp10",
                        "Environmental Audit",
                        List.of(
                                new Template.Fieldset("Is recycling being properly sorted?", "String", true),
                                new Template.Fieldset("Are green initiatives in place?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp11",
                        "Emergency Drill Evaluation",
                        List.of(
                                new Template.Fieldset("Were evacuation procedures followed correctly?", "String", true),
                                new Template.Fieldset("Did all employees participate?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp12",
                        "Workplace Diversity Review",
                        List.of(
                                new Template.Fieldset("Are hiring practices inclusive?", "String", true),
                                new Template.Fieldset("Are diversity training programs effective?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp13",
                        "Fire Safety Evaluation",
                        List.of(
                                new Template.Fieldset("Are fire extinguishers easily accessible?", "String", true),
                                new Template.Fieldset("Are evacuation routes clearly marked?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp14",
                        "Supplier Quality Assessment",
                        List.of(
                                new Template.Fieldset("Do suppliers meet expected quality standards?", "String", true),
                                new Template.Fieldset("Are supply chains regularly reviewed?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                ),

                new Template(
                        "Temp15",
                        "Workplace Safety",
                        List.of(
                                new Template.Fieldset("Are safety gloves provided?", "String", true),
                                new Template.Fieldset("Is PPE worn at all times?", "String", true)
                        ),
                        "Gurdeep",
                        "owner1@v1.com"
                ),

                new Template(
                        "Temp16",
                        "Annual Compliance",
                        List.of(
                                new Template.Fieldset("Has the document review been completed?", "String", true),
                                new Template.Fieldset("Are all approvals obtained?", "String", true)
                        ),
                        "Sean",
                        "owner2@v1.com"
                )


        );
    }

    public static List<Checklist> getDummyChecklists() {

        return List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL003", "Temp2", "Equipment Maintenance", false, false, LocalDate.of(2025, 5, 10), null,
                        List.of(new Field("Has the generator been serviced?", "No"), new Field("Is the fuel level sufficient?", "Yes")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL004", "Temp2", "Equipment Maintenance", false, false, LocalDate.of(2025, 5, 10), null,
                        List.of(new Field("Has the generator been serviced?", "No"), new Field("Is the fuel level sufficient?", "Yes")),
                        "Sean", "owner2@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL005", "Temp3", "Data Security Audit", false, false, LocalDate.of(2025, 5, 18), null,
                        List.of(new Field("Are passwords changed regularly?", "Yes"), new Field("Has the backup been verified?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL006", "Temp4", "Software Update Review", true, true, LocalDate.of(2025, 4, 15), LocalDate.of(2025, 4, 16),
                        List.of(new Field("Are all systems running the latest updates?", "Yes"), new Field("Has a rollback plan been created?", "No")),
                        "Sean", "owner2@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL007", "Temp5", "Training Compliance", false, false, LocalDate.of(2025, 5, 20), null,
                        List.of(new Field("Have all employees completed training?", "No"), new Field("Are refresher courses scheduled?", "Yes")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL008", "Temp6", "Facilities Inspection", true, false, LocalDate.of(2025, 4, 30), LocalDate.of(2025, 5, 1),
                        List.of(new Field("Is HVAC functioning?", "Yes"), new Field("Are security cameras operational?", "No")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL009", "Temp7", "Office Cleanliness Audit", true, true, LocalDate.of(2025, 4, 20), LocalDate.of(2025, 4, 21),
                        List.of(new Field("Are workspaces tidy?", "Yes"), new Field("Is trash disposal routine followed?", "No")),
                        "Gurdeep", "owner1@v1.com", "Hibbah", "user5@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL010", "Temp8", "Energy Efficiency Check", false, false, LocalDate.of(2025, 5, 12), null,
                        List.of(new Field("Are unused lights turned off?", "Yes"), new Field("Are appliances running efficiently?", "No")),
                        "Sean", "owner2@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL011", "Temp9", "Cybersecurity Compliance", true, false, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 4, 26),
                        List.of(new Field("Has multi-factor authentication been enabled?", "Yes"), new Field("Are access logs monitored regularly?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL012", "Temp10", "Environmental Audit", false, false, LocalDate.of(2025, 5, 25), null,
                        List.of(new Field("Is recycling being properly sorted?", "No"), new Field("Are green initiatives in place?", "Yes")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL013", "Temp11", "Emergency Drill Evaluation", false, false, LocalDate.of(2025, 5, 30), null,
                        List.of(new Field("Were evacuation procedures followed correctly?", "Yes"), new Field("Did all employees participate?", "No")),
                        "Gurdeep", "owner1@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL014", "Temp12", "Workplace Diversity Review", true, true, LocalDate.of(2025, 4, 10), LocalDate.of(2025, 4, 11),
                        List.of(new Field("Are hiring practices inclusive?", "Yes"), new Field("Are diversity training programs effective?", "No")),
                        "Sean", "owner2@v1.com", "Hibbah", "user5@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL015", "Temp13", "Fire Safety Evaluation", false, false, LocalDate.of(2025, 5, 28), null,
                        List.of(new Field("Are fire extinguishers easily accessible?", "Yes"), new Field("Are evacuation routes clearly marked?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL016", "Temp14", "Supplier Quality Assessment", true, false, LocalDate.of(2025, 4, 17), LocalDate.of(2025, 4, 18),
                        List.of(new Field("Do suppliers meet expected quality standards?", "Yes"), new Field("Are supply chains regularly reviewed?", "No")),
                        "Sean", "owner2@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com"),
                new Checklist("CL017", "Temp4", "Workplace Safety", false, false, LocalDate.of(2025, 5, 5), null,
                        List.of(new Field("Are safety gloves provided?", "Yes"), new Field("Is PPE worn at all times?", "No")),
                        "Gurdeep", "owner1@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL018", "Temp15", "Workplace Safety", false, false, LocalDate.of(2025, 5, 5), null,
                        List.of(new Field("Are safety gloves provided?", "Yes"), new Field("Is PPE worn at all times?", "No")),
                        "Gurdeep", "owner1@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL019", "Temp16", "Annual Compliance", true, false, LocalDate.of(2025, 4, 28), LocalDate.of(2025, 4, 29),
                        List.of(new Field("Has the document review been completed?", "Yes"), new Field("Are all approvals obtained?", "No")),
                        "Sean", "owner2@v1.com", "Albert", "user3@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL020", "Temp16", "Annual Compliance", true, false, LocalDate.of(2025, 4, 28), LocalDate.of(2025, 4, 29),
                        List.of(new Field("Has the document review been completed?", "Yes"), new Field("Are all approvals obtained?", "No")),
                        "Sean", "owner2@v1.com", "Barak", "user4@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL021", "Temp9", "Cybersecurity Compliance", true, false, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 4, 26),
                        List.of(new Field("Has multi-factor authentication been enabled?", "Yes"), new Field("Are access logs monitored regularly?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL022", "Temp9", "Cybersecurity Compliance", true, false, LocalDate.of(2025, 4, 25), LocalDate.of(2025, 4, 26),
                        List.of(new Field("Has multi-factor authentication been enabled?", "Yes"), new Field("Are access logs monitored regularly?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")

        );
    }
}
