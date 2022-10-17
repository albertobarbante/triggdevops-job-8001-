package com.trigg.candidatesreader.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.trigg.candidatesreader.dto.CandidatoDTO;
import com.trigg.candidatesreader.service.CandidateReaderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CandidateReaderController {
    private final CandidateReaderService candidateReaderService;


    @GetMapping("/candidates")
    private List<CandidatoDTO> getCandidatesByAge(
        @RequestParam
        Integer fromAge,
        @RequestParam
        Integer toAge
    ){
        try {
            return candidateReaderService.readByAge(fromAge, toAge);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
