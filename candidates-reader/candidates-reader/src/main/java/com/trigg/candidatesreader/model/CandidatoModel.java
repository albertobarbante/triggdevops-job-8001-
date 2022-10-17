package com.trigg.candidatesreader.model;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidatoModel {
    private String _id;
    private String nome;
    private String vaga;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;
}
