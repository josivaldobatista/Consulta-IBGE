package br.com.jfb.ibgewrapper.http;

import br.com.jfb.ibgewrapper.gateway.json.EstadoJson;
import br.com.jfb.ibgewrapper.service.estado.ConsultarEstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
@RequiredArgsConstructor
public class EstadoResource {

  private final ConsultarEstadoService estadoService;

  @GetMapping
  public List<EstadoJson> consultar() {
    return estadoService.execute();
  }
}
