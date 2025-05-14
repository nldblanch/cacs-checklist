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
                ),

                new Template(
                        "sc1", "Security Checklist",
                        List.of(
                                new Template.Fieldset("Practice", "dropdown", true),
                                new Template.Fieldset("Kantata Customer Name", "text", true),
                                new Template.Fieldset("Kantata Project ID & Project Name", "text", true),
                                new Template.Fieldset("What is the engagement type?", "radio", true, List.of(
                                        "Professional Services - Version 1 provide people, the customer owns the outcome",
                                        "Outcome Based - Discovery",
                                        "Outcome Based - Project or Programme of work",
                                        "Managed Services - Project"
                                        )),
                                new Template.Fieldset("Please give a short description of what we're doing in the engagement. For example:  \"Migrating data from Legacy on-premise to Oracle Cloud, or staff augmentation to build out new .NET forms for Traffic analysis for DfT\"", "textarea", true),
                                new Template.Fieldset("Do we keep a RAID for the engagement that considers cyber risk?", "radio", true, List.of("Yes - we have a RAID that considers cyber risks",
                                        "Yes - we have a RAID, but we do not call out cyber risks explicitly",
                                        "No - we don't track a RAID for this engagement",
                                        "Other")),
                                new Template.Fieldset("Does the customer have a dedicated security team and are we engaged with them?", "radio", true, List.of("Yes - they have a team and yes, we are engaged with them",
                                        "Yes - they have a team and no, we are not engaged with them",
                                        "No - they do not have a security team",
                                        "Other"
                                )),
                                new Template.Fieldset("Are we contractually committed to delivering any specific security-specific artefacts? For example a Security Management Plan, Business Continuity / Disaster Recovery Plan, Data Privacy Impact Assessment", "checkbox", true, List.of("Yes - Security Management Plan",
                                        "Yes - BCDR Plan",
                                        "Yes - Data Privacy Impact Assessment",
                                        "No - None required",
                                        "Other"
                                )),
                                new Template.Fieldset("Are we contractually committed to demonstrating compliance with any industry security standards or regulations, for example Cyber Essentials Plus, ISO 27001, NIST, NIS 2, NCSC Cyber Assessment Framework?", "checkbox", true, List.of("Cyber Essentials Plus",
                                        "ISO27001",
                                        "NCSC (E.g. Cloud Security or Cyber Assurance)",
                                        "NIS 2",
                                        "NIST Cyber Assurance Framework",
                                        "None of the above apply",
                                        "Other"
                                )),
                                new Template.Fieldset("Is there an established release management process for deploying releases to a Production environment?", "radio", true, List.of("Changes to Production are controlled and fully automated in nature",
                                        "We have some release management processes that are automated and some that are manual when deploying to Production. Manual steps are documented",
                                        "We have some release management processes that are automated and some that are manual when deploying to Production. Manual steps are not documented",
                                        "Our release management processes are fully manual when deploying to Production. Manual steps are documented",
                                        "Our release management processes are fully manual when deploying to Production. Manual steps are not documented",
                                        "Our team does not release to Production. Releases are handled by the customer",
                                        "Other"
                                )),
                                new Template.Fieldset("Is there a documented process for reporting security incidents to the customer?", "radio", true, List.of("Yes - the customer has a process for reporting security incidents",
                                        "No - no incident reporting process is in place",
                                        "Other"
                                )),
                                new Template.Fieldset("Is there a formal process for onboarding and offboarding team members to and from the customer’s systems?", "radio", true, List.of("Yes - onboarding and off-boarding processes are in place",
                                        "No - onboarding and off-boarding processes are not in place",
                                        "Other"
                                )),
                                new Template.Fieldset("Are team members trained on security expectations specific to the customer and project? (e.g. people are trained on using customer systems or they must review the customers security policies and procedures)", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("How often are access permissions to customer systems and data reviewed and reassessed? ", "radio", true, List.of("Daily to Weekly",
                                        "Weekly to Monthly",
                                        "Less often than Monthly",
                                        "Other"
                                )),
                                new Template.Fieldset("Are we building or using any form of AI components or solution for the customer?", "radio", true, List.of("Yes", "No")),
                                new Template.Fieldset("Which of the following are in place in your project or engagement", "checkbox", true, List.of("Secure coding awareness (e.g. OWASP Proactive controls or OWASP ASVS)",
                                        "Code reviews within the team",
                                        "Security testing or vulnerability assessment tooling as part of the deployment to different environments",
                                        "None of the above",
                                        "Other"
                                )),
                                new Template.Fieldset("Is access to production environments and secrets or any production tools/systems tightly controlled to specific, expected personnel? ", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("Will any form of security testing be performed by a 3rd party before a release to production? For example, an IT-Health Check or Penetration test that validates what Version 1 have built or configured.", "radio", true, List.of("Yes - everytime we release to production",
                                        "Yes - before go live, then annually",
                                        "Yes - client controls frequency/cadence",
                                        "Yes - checked annually",
                                        "No",
                                        "Other"
                                )),
                                new Template.Fieldset("How many open-source, third-party components or libraries are in use in the solution? In this context we mean anything that provides functionality that we didn't build, for example a postcode lookup web service, or a component that generates a PDF file. ", "radio", true, List.of("Less than 5",
                                        "Between 5 and 15",
                                        "Greater than 15",
                                        "Other"
                                )),
                                new Template.Fieldset("How often is patching for software vulnerabilities performed? Software in this case refers to any of the components, libraries or code we have built for a customer.", "radio", true, List.of("Daily to Weekly",
                                        "Weekly to Monthly",
                                        "Less often than Monthly",
                                        "Not at all",
                                        "Other"
                                )),
                                new Template.Fieldset("Does the project cross multiple territories? (e.g. UK/India, UK/USA, USA/INDIA, EU etc.)", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("Are there customer restrictions on where their data is stored or processed (e.g. UK only, EU Only)?", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("Are there measures in place to protect customer and Version 1 data throughout the project lifecycle?", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("Do any team members store or process any live customer data on their Version 1 laptop? ", "radio", true, List.of("No - we have environments specifically for storing and processing customer data",
                                        "No - we use sanitised (cleaned) or synthetic (generated) data for any tasks",
                                        "Yes - we need to do this as part of our data engineering or reporting work",
                                        "Yes - we need to do this as part of normal project delivery",
                                        "Other"
                                )),
new Template.Fieldset("Are permissions to access customer data clearly defined and regularly reviewed across all team members?", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("Are customer data disposal processes implemented at the end of the project?", "radio", true, List.of("Yes", "No", "Other")),
                                new Template.Fieldset("On a scale of 1-5, how happy are you with the security aspects of this engagement?", "rating", true),
                                new Template.Fieldset("Are there any other points you'd like to make about the projects security, or any improvements to this checklist?", "textarea", false),
                                new Template.Fieldset("", "checkbox", false, List.of("Send me an email receipt of my responses"))
                                ),
                        "Sam Britain", "sam.britain@v1.com"
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
