package com.testesunitarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    private String nome;

    private String email;

    private String cpf;

    private String telefone;
}
