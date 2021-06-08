package br.com.fiap.am;

import br.com.fiap.am.dto.Arquivo;
import br.com.fiap.am.entity.ArquivoEntity;
import br.com.fiap.am.repository.ArquivoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AMApplication {

	public static void main(String[] args) {
		SpringApplication.run(AMApplication.class, args);
	}

	@Autowired
	private ArquivoRepository arquivoRepository;

	@Bean
	InitializingBean populateDatabase() {
		return () -> {
			ArquivoEntity arquivo = new ArquivoEntity();
			arquivo.setDescricao("Arquivo 1");
			arquivo.setMunicipio("São Paulo - SP");
			arquivo.setUrl("http://www.africau.edu/images/default/sample.pdf");
			arquivoRepository.save(arquivo);


			arquivo = new ArquivoEntity();
			arquivo.setDescricao("Arquivo 2");
			arquivo.setMunicipio("Guarulhos - SP");
			arquivo.setUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
			arquivoRepository.save(arquivo);
		};
	}
}
