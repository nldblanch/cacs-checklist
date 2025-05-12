package com.v1.cacs_checklist.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.*;

public class TestData {
    public static List<Checklist> getDummyChecklists() {
        List<Checklist> checklists = new ArrayList<>();



        checklists.add(new Checklist(
                "chk002", "Data Backup Verification", false, false, "2025-05-15", null,
                Arrays.asList(
                        new Field("Backup Schedule Reviewed", ""),
                        new Field("Restore Test Completed", "")
                ),
                "Dave", "owner@v1.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk002", "Data Backup Verification", false, false, "2025-05-15", null,
                Arrays.asList(
                        new Field("Backup Schedule Reviewed", ""),
                        new Field("Restore Test Completed", "")
                ),
                "Dave", "owner@v1.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk011", "Security Form", true, false, "2025-04-15", "2025-03-29",
                Arrays.asList(
                        new Field("Have all employees completed security training?", "Yes"),
                        new Field("Are all passwords updated within the last 90 days?", "No")

                ),
                "Dave", "owner@v1.com", "Erin", "erin@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk012", "Security Form", false, false, "2025-05-11", null,
                Arrays.asList(
                        new Field("Have all employees completed security training?", ""),
                        new Field("Are all passwords updated within the last 90 days?", "")

                ),
                "Dave", "owner@v1.com", "Luke", "luke@company.com", "Frank", "frank@company.com"
        ));

        checklists.add(new Checklist(
                "chk013", "Security Form", false, false, "2025-05-11", null,
                Arrays.asList(
                        new Field("Have all employees completed security training?", ""),
                        new Field("Are all passwords updated within the last 90 days?", "")

                ),
                "Dave", "owner@v1.com", "Charlie", "charlie@company.com", "Frank", "frank@company.com"
        ));

        return checklists;
    }
}
