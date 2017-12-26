package org.cbioportal.genome_nexus.web.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainMixin
{
    @JsonProperty(value="db", required = true)
    @ApiModelProperty(value = "DB", required = false)
    private String db;

    @JsonProperty(value="name", required = true)
    @ApiModelProperty(value = "name", required = false)
    private String name;
}
