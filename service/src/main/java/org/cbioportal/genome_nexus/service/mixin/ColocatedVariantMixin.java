package org.cbioportal.genome_nexus.service.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColocatedVariantMixin 
{
    @JsonProperty(value="gnomad_nfe_allele", required = true)
    private String gnomadNfeAllele;

    @JsonProperty(value="gnomad_nfe_maf", required = true)
    private String gnomadNfeMaf;

    @JsonProperty(value="gnomad_afr_allele", required = true)
    private String gnomadAfrAllele;

    @JsonProperty(value="gnomad_afr_maf", required = true)
    private String gnomadAfrMaf;

    @JsonProperty(value="gnomad_eas_allele", required = true)
    private String gnomadEasAllele;

    @JsonProperty(value="gnomad_eas_maf", required = true)
    private String gnomadEasMaf;
}
