package org.cbioportal.genome_nexus.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Domain
{
    private String db;
    private String name;

    @Field(value="db")
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Field(value="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
