package com.trigg.candidatesreader.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CandidatoDTO {
    private String id;
    private String nome;
    private String vaga;
    private Integer idade;
}
