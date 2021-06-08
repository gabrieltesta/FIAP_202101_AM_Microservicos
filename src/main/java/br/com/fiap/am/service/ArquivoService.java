package br.com.fiap.am.service;

import java.util.List;

import br.com.fiap.am.dto.Arquivo;

public interface ArquivoService {
    List<Arquivo>listaArquivos();
    Arquivo salvarArquivo(Arquivo arquivo);


}
