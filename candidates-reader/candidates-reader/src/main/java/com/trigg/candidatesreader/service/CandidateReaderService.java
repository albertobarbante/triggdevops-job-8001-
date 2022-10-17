package com.trigg.candidatesreader.service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trigg.candidatesreader.dto.CandidatoDTO;
import com.trigg.candidatesreader.model.VagaModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateReaderService {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<CandidatoDTO> readByAge(Integer fromAge, Integer toAge)
            throws JsonParseException, JsonMappingException, IOException {
        var candidatoDTOList = new ArrayList<CandidatoDTO>();
        var vagaModel = mapper.readValue(new FileReader("candidates-reader/candidatos.json"), VagaModel.class);
        vagaModel.getCandidatos().stream().forEach(c -> candidatoDTOList.add(new CandidatoDTO(
                c.getNome(), c.getVaga(), c.get_id(), calculateAge(c.getData_nascimento()))));
        return candidatoDTOList.stream().sorted(Comparator.comparing(CandidatoDTO::getIdade)).collect(Collectors.toList());

    }

    private Integer calculateAge(LocalDate nascimento) {
        return LocalDate.now().getYear() - nascimento.getYear();
    }
}