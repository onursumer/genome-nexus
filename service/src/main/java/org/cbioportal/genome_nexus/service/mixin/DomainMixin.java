package org.cbioportal.genome_nexus.service.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainMixin
{
    @JsonProperty(value="db", required = true)
    private String db;

    @JsonProperty(value="name", required = true)
    private String name;
}
