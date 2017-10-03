package com.gfi.appcommercial.mocks;

import com.gfi.appcommercial.model.Need;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import io.bloco.faker.Faker;

public class NeedMocks {

    private Faker faker;

    private List<Need> needs;

    public NeedMocks() {
        faker = new Faker();
    }

    public List<Need> getNeeds(int number) {
        List<Need> needs = new ArrayList<>();

        for (int i=0 ; i<number ; i++) {
            needs.add(createNeed());
        }

        return needs;
    }

    private Need createNeed() {

        List<String> mainKeyFactors = new ArrayList<>();

        return new Need(
                faker.name.name(),
                faker.company.name(),
                faker.name.name(),
                faker.lorem.sentence(),
                faker.lorem.paragraph(),
                faker.address.streetAddress(),
                faker.number.hexadecimal(6),
                randomStatus(),
                randomMainKeyFactors(),
                randomConsultants(),
                faker.number.between(1, 24),
                faker.number.between(1, 5),
                faker.date.forward(),
                faker.date.backward(),
                new HashMap<String, File>()
        );
    }

    private List<String> randomMainKeyFactors() {
        List<String> consultants = new ArrayList<>();

        for (int i=0 ; i < new Random().nextInt(3) ; i++) {
            consultants.add(faker.lorem.sentence());
        }

        return consultants;
    }

    private List<String> randomConsultants() {
        List<String> consultants = new ArrayList<>();

        for (int i=0 ; i < new Random().nextInt(5) ; i++) {
            consultants.add(faker.name.name());
        }

        return consultants;
    }

    private String randomStatus() {
        int rnd = new Random().nextInt(3);

        switch (rnd) {
            case 0:
                return "Open";
            case 1:
                return "Won";
            case 2:
                return "Lost";
            default:
                return "?";
        }
    }
}
