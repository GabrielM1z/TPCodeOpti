package org.mines.address.domain.model;

import org.mines.address.domain.model.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record Meal(UUID id, int heure, Restorant restorant, People people) {


    public static final class MealBuilder {
        private UUID id;
        private int heure;
        private Restorant restorant;
        private People people;

        private MealBuilder() {
        }

        public static MealBuilder aMeal() {
            return new MealBuilder();
        }

        public MealBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public MealBuilder withHeure(int heure) {
            this.heure = heure;
            return this;
        }

        public MealBuilder withRestorant(Restorant restorant) {
            this.restorant = restorant;
            return this;
        }

        public MealBuilder withPeople(People people) {
            this.people = people;
            return this;
        }

        public Meal build() {
            return new Meal(id, heure, restorant, people);
        }
    }
}