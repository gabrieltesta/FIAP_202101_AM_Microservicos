package br.com.fiap.am.repository;

import br.com.fiap.am.entity.ArquivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArquivoRepository extends JpaRepository<ArquivoEntity, Long>{

}
