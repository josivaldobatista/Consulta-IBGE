package br.com.jfb.ibgewrapper.http;

import br.com.jfb.ibgewrapper.gateway.feign.CidadeClient;
import br.com.jfb.ibgewrapper.gateway.json.CidadeJson;
import br.com.jfb.ibgewrapper.gateway.json.EstadoJson;
import br.com.jfb.ibgewrapper.service.cidade.ConsultarCidadePorUFService;
import br.com.jfb.ibgewrapper.service.estado.ConsultarEstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoResource {

  private final ConsultarEstadoService estadoService;

  private final ConsultarCidadePorUFService service;

  @GetMapping
  public List<EstadoJson> consultar() {
    return estadoService.execute();
  }

  @GetMapping("/{id}/cidades")
  public List<CidadeJson> consulta(@PathVariable("id") String uf) {
    return service.execute(uf);
  }

}
