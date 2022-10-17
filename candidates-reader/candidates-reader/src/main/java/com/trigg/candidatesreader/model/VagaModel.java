package com.trigg.candidatesreader.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VagaModel {
    private String recrutador;
    private String dtAberturaVaga;
    private ArrayList<CandidatoModel> candidatos;
}
