package br.com.jfb.ibgewrapper.service.estado;

import br.com.jfb.ibgewrapper.gateway.feign.EstadoClient;
import br.com.jfb.ibgewrapper.gateway.json.EstadoJson;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ConsultarEstadoService {

  public List<EstadoJson> execute() {
    EstadoClient estadoClient = Feign.builder()
        .decoder(new GsonDecoder())
        .target(EstadoClient.class, "http://servicodados.ibge.gov.br");

    long tempoInicial = System.currentTimeMillis();

    List<EstadoJson> listEstados = estadoClient.getEstados();

    log.info("MÉTODO ESTADO SERVICE EXECUTOU EM: {}", (System.currentTimeMillis() - tempoInicial) / 1000d);
    return listEstados;
  }

}
