package br.com.jfb.ibgewrapper.gateway.feign;

import br.com.jfb.ibgewrapper.gateway.json.CidadeJson;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CidadeClient {

  @RequestLine("GET /api/v1/localidades/estados/{UF}/municipios")
  List<CidadeJson> getCidades(@Param("UF") String uf);
}
