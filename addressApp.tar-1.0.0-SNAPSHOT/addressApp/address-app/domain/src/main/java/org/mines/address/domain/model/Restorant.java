package org.mines.address.domain.model;

import java.util.UUID;

public record Restorant(UUID id, String name, int rate, String category) {


    public static final class RestorantBuilder {
        private UUID id;
        private String name;
        private int rate;
        private String category;

        private RestorantBuilder() {
        }

        public static RestorantBuilder aRestorant() {
            return new RestorantBuilder();
        }

        public RestorantBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public RestorantBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public RestorantBuilder withRate(int rate) {
            this.rate = rate;
            return this;
        }

        public RestorantBuilder withCategory(String category) {
            this.category = category;
            return this;
        }

        public Restorant build() {
            return new Restorant(id, name, rate, category);
        }
    }
}