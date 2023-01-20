package br.com.jfb.ibgewrapper.service.cidade;

import br.com.jfb.ibgewrapper.gateway.feign.CidadeClient;
import br.com.jfb.ibgewrapper.gateway.json.CidadeJson;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ConsultarCidadePorUFService {

  public List<CidadeJson> execute(String uf) {
    CidadeClient client = Feign.builder()
        .decoder(new GsonDecoder())
        .target(CidadeClient.class, "http://servicodados.ibge.gov.br");

    long tempoInicial = System.currentTimeMillis();

    List<CidadeJson> listEstados = client.getCidades(uf);
    log.info("MÉTODO CIDADES SERVICE EXECUTOU EM: {}", (System.currentTimeMillis() - tempoInicial) / 1000d);

    return listEstados;
  }
}
