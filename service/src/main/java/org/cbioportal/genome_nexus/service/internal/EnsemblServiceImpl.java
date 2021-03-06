package org.cbioportal.genome_nexus.service.internal;

import org.cbioportal.genome_nexus.model.EnsemblGene;
import org.cbioportal.genome_nexus.model.EnsemblTranscript;
import org.cbioportal.genome_nexus.persistence.EnsemblRepository;
import org.cbioportal.genome_nexus.service.EnsemblService;
import org.cbioportal.genome_nexus.service.exception.EnsemblTranscriptNotFoundException;
import org.cbioportal.genome_nexus.service.exception.NoEnsemblGeneIdForEntrezGeneIdException;
import org.cbioportal.genome_nexus.service.exception.NoEnsemblGeneIdForHugoSymbolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EnsemblServiceImpl implements EnsemblService
{
    private final EnsemblRepository ensemblRepository;

    @Autowired
    public EnsemblServiceImpl(EnsemblRepository ensemblRepository)
    {
        this.ensemblRepository = ensemblRepository;
    }

    @Override
    public EnsemblTranscript getEnsemblTranscriptsByTranscriptId(String transcriptId) {
        return this.ensemblRepository.findOneByTranscriptId(transcriptId);
    }

    @Override
    public EnsemblGene getCanonicalEnsemblGeneIdByHugoSymbol(String hugoSymbol)
        throws NoEnsemblGeneIdForHugoSymbolException
    {
        EnsemblGene ensemblGene = this.ensemblRepository.getCanonicalEnsemblGeneIdByHugoSymbol(hugoSymbol);

        if (ensemblGene == null) {
            throw new NoEnsemblGeneIdForHugoSymbolException(hugoSymbol);
        }

        return ensemblGene;
    }

    @Override
    public EnsemblGene getCanonicalEnsemblGeneIdByEntrezGeneId(String entrezGeneId)
        throws NoEnsemblGeneIdForEntrezGeneIdException
    {
        EnsemblGene ensemblGene = this.ensemblRepository.getCanonicalEnsemblGeneIdByEntrezGeneId(entrezGeneId);

        if (ensemblGene == null) {
            throw new NoEnsemblGeneIdForEntrezGeneIdException(entrezGeneId);
        }

        return ensemblGene;
    }

    @Override
    public List<EnsemblGene> getCanonicalEnsemblGeneIdByHugoSymbols(List<String> hugoSymbols) {
        List<EnsemblGene> ensemblGenes = new ArrayList<>();

        for (String hugoSymbol : hugoSymbols)
        {
            try {
                ensemblGenes.add(this.getCanonicalEnsemblGeneIdByHugoSymbol(hugoSymbol));
            } catch (NoEnsemblGeneIdForHugoSymbolException e) {
                // ignore the exception for this hugo symbol
            }
        }

        return ensemblGenes;
    }

    @Override
    public List<EnsemblGene> getCanonicalEnsemblGeneIdByEntrezGeneIds(List<String> entrezGeneIds) {
        List<EnsemblGene> ensemblGenes = new ArrayList<>();

        for (String entrezGeneId : entrezGeneIds)
        {
            try {
                ensemblGenes.add(this.getCanonicalEnsemblGeneIdByEntrezGeneId(entrezGeneId));
            } catch (NoEnsemblGeneIdForEntrezGeneIdException e) {
                // ignore the exception for this hugo symbol
            }
        }

        return ensemblGenes;
    }

    @Override
    public EnsemblTranscript getCanonicalEnsemblTranscriptByHugoSymbol(String hugoSymbol, String isoformOverrideSource)
        throws EnsemblTranscriptNotFoundException
    {
        EnsemblTranscript transcript = this.ensemblRepository.findOneByHugoSymbolIgnoreCase(hugoSymbol, isoformOverrideSource);

        if (transcript == null) {
            throw new EnsemblTranscriptNotFoundException(hugoSymbol, isoformOverrideSource);
        }

        return transcript;
    }

    @Override
    public List<EnsemblTranscript> getCanonicalEnsemblTranscriptsByHugoSymbols(List<String> hugoSymbols, String isoformOverrideSource) {
        List<EnsemblTranscript> transcripts = new ArrayList<>();

        for (String hugoSymbol : hugoSymbols)
        {
            try {
                transcripts.add(this.getCanonicalEnsemblTranscriptByHugoSymbol(hugoSymbol, isoformOverrideSource));
            } catch (EnsemblTranscriptNotFoundException e) {
                // ignore the exception for this transcript
            }
        }

        return transcripts;
    }

    @Override
    public List<EnsemblTranscript> getEnsemblTranscripts(String geneId, String proteinId, String hugoSymbol)
    {
        if (geneId == null && proteinId == null && hugoSymbol == null)
        {
            return new ArrayList<EnsemblTranscript>();
        }
        else if (geneId != null && proteinId == null && hugoSymbol == null)
        {
            return this.ensemblRepository.findByGeneId(geneId);
        }
        else if (geneId != null && proteinId != null && hugoSymbol == null)
        {
            return this.ensemblRepository.findByGeneIdAndProteinId(geneId, proteinId);
        }
        else if (geneId != null && proteinId == null && hugoSymbol != null)
        {
            return this.ensemblRepository.findByGeneIdAndHugoSymbolsIn(geneId, Arrays.<String>asList(hugoSymbol));
        }
        else if (geneId == null && proteinId != null && hugoSymbol == null)
        {
            return this.ensemblRepository.findByProteinId(proteinId);
        }
        else if (geneId == null && proteinId != null && hugoSymbol != null)
        {
            return this.ensemblRepository.findByProteinIdAndHugoSymbolsIn(proteinId, Arrays.<String>asList(hugoSymbol));
        }
        else
        {
            return this.ensemblRepository.findByHugoSymbolsIn(Arrays.<String>asList(hugoSymbol));
        }
    }

    @Override
    public List<EnsemblTranscript> getEnsemblTranscripts(List<String> transcriptIds, List<String> geneIds, List<String> proteinIds, List<String> hugoSymbols) {
        if (transcriptIds != null && transcriptIds.size() > 0) {
            return this.ensemblRepository.findByTranscriptIdIn(transcriptIds);
        }
        else if (geneIds != null && geneIds.size() > 0) {
            return this.ensemblRepository.findByGeneIdIn(geneIds);
        }
        else if (proteinIds != null && proteinIds.size() > 0) {
            return this.ensemblRepository.findByProteinIdIn(proteinIds);
        }
        else if (hugoSymbols != null && hugoSymbols.size() > 0) {
            return this.ensemblRepository.findByHugoSymbolsIn(hugoSymbols);
        }
        else {
            return new ArrayList<EnsemblTranscript>();
        }
    }
}
