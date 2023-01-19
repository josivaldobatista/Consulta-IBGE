package br.com.jfb.ibgewrapper.service.estado;

import br.com.jfb.ibgewrapper.gateway.feign.EstadoClient;
import br.com.jfb.ibgewrapper.gateway.json.EstadoJson;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarEstadoService {

  public List<EstadoJson> execute() {
    EstadoClient estadoClient = Feign.builder()
        .decoder(new GsonDecoder())
        .target(EstadoClient.class, "http://servicodados.ibge.gov.br");
    return estadoClient.getEstados();
  }

}
