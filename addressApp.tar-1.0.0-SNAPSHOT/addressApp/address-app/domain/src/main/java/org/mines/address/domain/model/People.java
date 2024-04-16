package org.mines.address.domain.model;

import java.util.UUID;

public record People(UUID id, String name, String firstName, int age) {

    public static final class PeopleBuilder {
        private UUID id;
        private String name;
        private String firstName;
        private int age;

        private PeopleBuilder() {
        }

        public static PeopleBuilder aPeople() {
            return new PeopleBuilder();
        }

        public PeopleBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public PeopleBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PeopleBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PeopleBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public People build() {
            return new People(id, name, firstName, age);
        }
    }
}