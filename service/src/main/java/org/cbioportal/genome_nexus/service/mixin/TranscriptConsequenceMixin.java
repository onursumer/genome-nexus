package org.cbioportal.genome_nexus.service.mixin;

import com.fasterxml.jackson.annotation.*;
import org.cbioportal.genome_nexus.model.Domain;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranscriptConsequenceMixin
{
    @JsonProperty(value="transcript_id", required = true)
    private String transcriptId;

    @JsonProperty(value="hgvsp", required = true)
    private String hgvsp;

    @JsonProperty(value="hgvsc", required = true)
    private String hgvsc;

    @JsonProperty(value="variant_allele", required = true)
    private String variantAllele;

    @JsonProperty(value="codons", required = true)
    private String codons;

    @JsonProperty(value="protein_id", required = true)
    private String proteinId;

    @JsonProperty(value="protein_start", required = true)
    private Integer proteinStart;

    @JsonProperty(value="protein_end", required = true)
    private Integer proteinEnd;

    @JsonProperty(value="gene_symbol", required = true)
    private String geneSymbol;

    @JsonProperty(value="gene_id", required = true)
    private String geneId;

    @JsonProperty(value="amino_acids", required = true)
    private String aminoAcids;

    @JsonProperty(value="hgnc_id", required = true)
    private Integer hgncId;

    @JsonProperty(value="canonical", required = true)
    private String canonical;

    @JsonProperty(value="polyphen_score", required = true)
    private Double polyphenScore;

    @JsonProperty(value="polyphen_prediction", required = true)
    private String polyphenPrediction;

    @JsonProperty(value="sift_score", required = true)
    private Double siftScore;

    @JsonProperty(value="sift_prediction", required = true)
    private String siftPrediction;

    @JsonProperty(value="cdna_start", required = true)
    private Integer cdnaStart;

    @JsonProperty(value="cdna_end", required = true)
    private Integer cdnaEnd;

    @JsonProperty(value="cds_start", required = true)
    private Integer cdsStart;

    @JsonProperty(value="cds_end", required = true)
    private Integer cdsEnd;

    @JsonProperty(value="biotype", required = true)
    private String biotype;

    @JsonProperty(value="gene_symbol_source", required = true)
    private String geneSymbolSource;

    @JsonProperty(value="impact", required = true)
    private String impact;

    @JsonProperty(value="refseq_transcript_ids", required = true)
    private List<String> refseqTranscriptIds;

    @JsonProperty(value="consequence_terms", required = true)
    private List<String> consequenceTerms;

    @JsonProperty(value="domains", required = true)
    private List<Domain> domains;

    @JsonIgnore
    private Map<String, Object> dynamicProps;
}
