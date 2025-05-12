package com.v1.cacs_checklist.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;

public class TestData {
    public static List<Checklist> getDummyChecklists() {
        List<Checklist> checklists = new ArrayList<>();

        checklists.add(new Checklist(
                "chk001", "Office Security Audit", true, true, "2025-05-01", "2025-04-30",
                Arrays.asList(
                        new Field("Door Locks Checked", "Yes"),
                        new Field("CCTV Operational", "Yes")
                ),
                "Alice", "alice@company.com", "Bob", "bob@company.com", "Carol", "carol@company.com"
        ));

        checklists.add(new Checklist(
                "chk002", "Data Backup Verification", false, false, "2025-05-15", null,
                Arrays.asList(
                        new Field("Backup Schedule Reviewed", ""),
                        new Field("Restore Test Completed", "")
                ),
                "Dave", "dave@company.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk002", "Data Backup Verification", false, false, "2025-05-15", null,
                Arrays.asList(
                        new Field("Backup Schedule Reviewed", ""),
                        new Field("Restore Test Completed", "")
                ),
                "Dave", "dave@company.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk003", "Network Security Review", true, false, "2025-05-10", "2025-05-09",
                Arrays.asList(
                        new Field("Firewall Rules Audited", "Completed"),
                        new Field("Intrusion Detection Logs Reviewed", "Pending")
                ),
                "Grace", "grace@company.com", "Heidi", "heidi@company.com", "Ivan", "ivan@company.com"
        ));

        checklists.add(new Checklist(
                "chk004", "Physical Access Control", true, true, "2025-04-25", "2025-04-24",
                Arrays.asList(
                        new Field("Badge Access Logs Reviewed", "Yes"),
                        new Field("Visitor Logs Verified", "Yes")
                ),
                "Judy", "judy@company.com", "Ken", "ken@company.com", "Laura", "laura@company.com"
        ));

        checklists.add(new Checklist(
                "chk005", "Software Patch Compliance", false, false, "2025-05-20", null,
                Arrays.asList(
                        new Field("Critical Patches Applied", ""),
                        new Field("Patch Verification Logs", "")
                ),
                "Mike", "mike@company.com", "Nina", "nina@company.com", "Oliver", "oliver@company.com"
        ));

        checklists.add(new Checklist(
                "chk006", "Incident Response Drill", true, false, "2025-05-05", "2025-05-04",
                Arrays.asList(
                        new Field("Drill Conducted", "Yes"),
                        new Field("Team Feedback Collected", "Yes")
                ),
                "Paul", "paul@company.com", "Quinn", "quinn@company.com", "Rachel", "rachel@company.com"
        ));

        checklists.add(new Checklist(
                "chk007", "Cloud Security Review", false, false, "2025-05-18", null,
                Arrays.asList(
                        new Field("IAM Policies Reviewed", ""),
                        new Field("Storage Encryption Verified", "")
                ),
                "Steve", "steve@company.com", "Tina", "tina@company.com", "Uma", "uma@company.com"
        ));

        checklists.add(new Checklist(
                "chk008", "Endpoint Protection Audit", true, true, "2025-04-28", "2025-04-27",
                Arrays.asList(
                        new Field("Antivirus Updated", "Yes"),
                        new Field("Malware Scan Completed", "Yes")
                ),
                "Victor", "victor@company.com", "Wendy", "wendy@company.com", "Xavier", "xavier@company.com"
        ));

        checklists.add(new Checklist(
                "chk009", "Remote Access Policy Review", false, false, "2025-05-22", null,
                Arrays.asList(
                        new Field("VPN Logs Reviewed", ""),
                        new Field("Access Rights Audited", "")
                ),
                "Yara", "yara@company.com", "Zane", "zane@company.com", "Amy", "amy@company.com"
        ));

        checklists.add(new Checklist(
                "chk010", "Compliance Documentation Review", true, true, "2025-05-01", "2025-04-29",
                Arrays.asList(
                        new Field("Policy Documents Updated", "Yes"),
                        new Field("Compliance Checklist Signed", "Yes")
                ),
                "Brian", "brian@company.com", "Claire", "claire@company.com", "Dan", "dan@company.com"
        ));

        checklists.add(new Checklist(
                "chk011", "Security Form", true, false, "2025-04-15", "2025-03-29",
                Arrays.asList(
                        new Field("Have all employees completed security training?", "Yes"),
                        new Field("Are all passwords updated within the last 90 days?", "No")

                ),
                "Dave", "dave@company.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk012", "Security Form", false, false, "2025-05-11", null,
                Arrays.asList(
                        new Field("Have all employees completed security training?", ""),
                        new Field("Are all passwords updated within the last 90 days?", "")

                ),
                "Dave", "dave@company.com", "Luke", "luke@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk013", "Security Form", false, false, "2025-05-11", null,
                Arrays.asList(
                        new Field("Have all employees completed security training?", ""),
                        new Field("Are all passwords updated within the last 90 days?", "")

                ),
                "Dave", "dave@company.com", "Charlie", "charlie@company.com", "Frank", "frank@company.com"
        ));

        return checklists;
    }
}
