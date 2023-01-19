package br.com.jfb.ibgewrapper.gateway.feign;

import br.com.jfb.ibgewrapper.gateway.json.EstadoJson;
import feign.RequestLine;

import java.util.List;

public interface EstadoClient {

  // http://servicodados.ibge.gov.br/api/v1/localidades/estados <- API IBGE
  // http://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios

  @RequestLine("GET /api/v1/localidades/estados")
  List<EstadoJson> getEstados();

}
