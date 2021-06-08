package br.com.fiap.am.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.dto.Arquivo;
import br.com.fiap.am.entity.ArquivoEntity;
import br.com.fiap.am.repository.ArquivoRepository;
import br.com.fiap.am.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArquivoServiceImpl implements ArquivoService {

    @Autowired
    private ArquivoRepository repository;

    @Override
    public List<Arquivo> listaArquivos() {
        List<ArquivoEntity> lista = repository.findAll();
        List<Arquivo> intencoes = fromTo(lista);
        return intencoes;
    }


    private List<Arquivo> fromTo(List<ArquivoEntity> lista){
        List<Arquivo> listaDto = new ArrayList<>();
        for (ArquivoEntity produtoEntity : lista) {
            Arquivo dto = new Arquivo();
            dto.setId(produtoEntity.getId());
            dto.setDescricao(produtoEntity.getDescricao());
            dto.setMunicipio(produtoEntity.getMunicipio());
            dto.setUrl(produtoEntity.getUrl());
            dto.setObservacao(produtoEntity.getObservacao());
            dto.setStatus(produtoEntity.getStatus());
            listaDto.add(dto);
        }
        return listaDto;
    }

    @Override
    public Arquivo salvarArquivo(Arquivo arquivo) {
        ArquivoEntity entity = fromTo(arquivo);
        entity = repository.save(entity);
        Arquivo arquivoRetorno = fromTo(entity);
        return arquivoRetorno;
    }

    private Arquivo fromTo(ArquivoEntity entity){
        Arquivo arquivo =  new Arquivo();
        arquivo.setId(entity.getId());
        arquivo.setDescricao(entity.getDescricao());
        arquivo.setMunicipio(entity.getMunicipio());
        arquivo.setUrl(entity.getUrl());
        arquivo.setObservacao(entity.getObservacao());
        arquivo.setStatus(entity.getStatus());
        return arquivo;
    }

    private ArquivoEntity fromTo(Arquivo arquivo){
        ArquivoEntity entity =  new ArquivoEntity();
        entity.setId(arquivo.getId());
        entity.setDescricao(arquivo.getDescricao());
        entity.setMunicipio(arquivo.getMunicipio());
        entity.setUrl(arquivo.getUrl());
        entity.setObservacao(arquivo.getObservacao());
        entity.setStatus(arquivo.getStatus());
        return entity;
    }

}
