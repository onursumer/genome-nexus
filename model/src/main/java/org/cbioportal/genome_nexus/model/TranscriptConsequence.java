/*
 * Copyright (c) 2016 Memorial Sloan-Kettering Cancer Center.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY OR FITNESS
 * FOR A PARTICULAR PURPOSE. The software and documentation provided hereunder
 * is on an "as is" basis, and Memorial Sloan-Kettering Cancer Center has no
 * obligations to provide maintenance, support, updates, enhancements or
 * modifications. In no event shall Memorial Sloan-Kettering Cancer Center be
 * liable to any party for direct, indirect, special, incidental or
 * consequential damages, including lost profits, arising out of the use of this
 * software and its documentation, even if Memorial Sloan-Kettering Cancer
 * Center has been advised of the possibility of such damage.
 */

/*
 * This file is part of cBioPortal Genome Nexus.
 *
 * cBioPortal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.cbioportal.genome_nexus.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Selcuk Onur Sumer
 */
public class TranscriptConsequence
{
    private String transcriptId;

    private String hgvsp;
    private String hgvsc;
    private String variantAllele;
    private String codons;
    private String proteinId;
    private Integer proteinStart;
    private Integer proteinEnd;
    private String geneSymbol;
    private String geneId;
    private String aminoAcids;
    private Integer hgncId;
    private String canonical;
    private Double polyphenScore;
    private String polyphenPrediction;
    private Double siftScore;
    private String siftPrediction;
    private Integer cdnaStart;
    private Integer cdnaEnd;
    private Integer cdsStart;
    private Integer cdsEnd;
    private String biotype;
    private String geneSymbolSource;
    private String impact;

    private List<String> refseqTranscriptIds;
    private List<String> consequenceTerms;
    private List<Domain> domains;

    private Map<String, Object> dynamicProps;

    public TranscriptConsequence()
    {
        this(null);
    }

    public TranscriptConsequence(String transcriptId)
    {
        this.transcriptId = transcriptId;
        this.dynamicProps = new LinkedHashMap<>();
    }

    @Field(value="transcript_id")
    public String getTranscriptId()
    {
        return transcriptId;
    }

    public void setTranscriptId(String transcriptId)
    {
        this.transcriptId = transcriptId;
    }

    @Field(value="hgvsp")
    public String getHgvsp()
    {
        return hgvsp;
    }

    public void setHgvsp(String hgvsp)
    {
        this.hgvsp = hgvsp;
    }

    @Field(value="hgvsc")
    public String getHgvsc()
    {
        return hgvsc;
    }

    public void setHgvsc(String hgvsc)
    {
        this.hgvsc = hgvsc;
    }

    @Field(value="variant_allele")
    public String getVariantAllele()
    {
        return variantAllele;
    }

    public void setVariantAllele(String variantAllele)
    {
        this.variantAllele = variantAllele;
    }

    @Field(value="polyphen_score")
    public Double getPolyphenScore()
    {
        return polyphenScore;
    }

    public void setPolyphenScore(Double polyphenScore) { this.polyphenScore = polyphenScore; }

    @Field(value="polyphen_prediction")
    public String getPolyphenPrediction()
    {
        return polyphenPrediction;
    }

    public void setPolyphenPrediction(String polyphenPrediction) { this.polyphenPrediction = polyphenPrediction; }

    @Field(value="sift_score")
    public Double getSiftScore()
    {
        return siftScore;
    }

    public void setSiftScore(Double siftScore) { this.siftScore = siftScore; }

    @Field(value="sift_prediction")
    public String getSiftPrediction()
    {
        return siftPrediction;
    }

    public void setSiftPrediction(String siftPrediction) { this.siftPrediction = siftPrediction; }

    @Field(value="codons")
    public String getCodons()
    {
        return codons;
    }

    public void setCodons(String codons)
    {
        this.codons = codons;
    }

    @Field(value="protein_id")
    public String getProteinId()
    {
        return proteinId;
    }

    public void setProteinId(String proteinId)
    {
        this.proteinId = proteinId;
    }

    @Field(value="protein_start")
    public Integer getProteinStart()
    {
        return proteinStart;
    }

    public void setProteinStart(Integer proteinStart)
    {
        this.proteinStart = proteinStart;
    }

    @Field(value="protein_end")
    public Integer getProteinEnd()
    {
        return proteinEnd;
    }

    public void setProteinEnd(Integer proteinEnd)
    {
        this.proteinEnd = proteinEnd;
    }

    @Field(value="gene_symbol")
    public String getGeneSymbol()
    {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol)
    {
        this.geneSymbol = geneSymbol;
    }

    @Field(value="gene_id")
    public String getGeneId()
    {
        return geneId;
    }

    public void setGeneId(String geneId)
    {
        this.geneId = geneId;
    }

    @Field(value="amino_acids")
    public String getAminoAcids()
    {
        return aminoAcids;
    }

    public void setAminoAcids(String aminoAcids)
    {
        this.aminoAcids = aminoAcids;
    }

    @Field(value="hgnc_id")
    public Integer getHgncId()
    {
        return hgncId;
    }

    public void setHgncId(Integer hgncId)
    {
        this.hgncId = hgncId;
    }

    @Field(value="canonical")
    public String getCanonical()
    {
        return canonical;
    }

    public void setCanonical(String canonical)
    {
        this.canonical = canonical;
    }

    @Field(value="refseq_transcript_ids")
    public List<String> getRefseqTranscriptIds()
    {
        return refseqTranscriptIds;
    }

    public void setRefseqTranscriptIds(List<String> refseqTranscriptIds)
    {
        this.refseqTranscriptIds = refseqTranscriptIds;
    }

    @Field(value="consequence_terms")
    public List<String> getConsequenceTerms()
    {
        return consequenceTerms;
    }

    public void setConsequenceTerms(List<String> consequenceTerms)
    {
        this.consequenceTerms = consequenceTerms;
    }

    @Field(value="cdna_start")
    public Integer getCdnaStart() {
        return cdnaStart;
    }

    public void setCdnaStart(Integer cdnaStart) {
        this.cdnaStart = cdnaStart;
    }

    @Field(value="cdna_end")
    public Integer getCdnaEnd() {
        return cdnaEnd;
    }

    public void setCdnaEnd(Integer cdnaEnd) {
        this.cdnaEnd = cdnaEnd;
    }

    @Field(value="cds_start")
    public Integer getCdsStart() {
        return cdsStart;
    }

    public void setCdsStart(Integer cdsStart) {
        this.cdsStart = cdsStart;
    }

    @Field(value="cds_end")
    public Integer getCdsEnd() {
        return cdsEnd;
    }

    public void setCdsEnd(Integer cdsEnd) {
        this.cdsEnd = cdsEnd;
    }

    @Field(value="biotype")
    public String getBiotype() {
        return biotype;
    }

    public void setBiotype(String biotype) {
        this.biotype = biotype;
    }

    @Field(value="gene_symbol_source")
    public String getGeneSymbolSource() {
        return geneSymbolSource;
    }

    public void setGeneSymbolSource(String geneSymbolSource) {
        this.geneSymbolSource = geneSymbolSource;
    }

    @Field(value="impact")
    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    @Field(value="domains")
    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    // this is to dynamically add additional properties for this transcript
    // anything added into the dynamic props map will be returned as an additional
    // json property

    public void setDynamicProp(String key, Object value)
    {
        this.dynamicProps.put(key, value);
    }

    public Map<String, Object> getDynamicProps()
    {
        return this.dynamicProps;
    }
}
