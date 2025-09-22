package com.example.streamingvideos.controller;

import com.example.streamingvideos.entity.Usuario;
import com.example.streamingvideos.entity.Video;
import com.example.streamingvideos.service.QueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class QueryController {

    private final QueryService queryService;

    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/videos/titulo/{titulo}")
    public List<Video> buscarVideosPorTitulo(@PathVariable String titulo) {
        return queryService.buscarVideosPorTitulo(titulo);
    }

    @GetMapping("/videos/categoria/{nomeCategoria}")
    public List<Video> buscarVideosPorCategoria(@PathVariable String nomeCategoria) {
        return queryService.buscarVideosPorCategoria(nomeCategoria);
    }

    @GetMapping("/videos/top10-avaliados")
    public List<Video> buscarTop10VideosMaisBemAvaliados() {
        return queryService.buscarTop10VideosMaisBemAvaliados();
    }

    @GetMapping("/videos/top10-assistidos")
    public List<Video> buscarTop10VideosMaisAssistidos() {
        return queryService.buscarTop10VideosMaisAssistidos();
    }

    @GetMapping("/usuarios/mais-assistiu")
    public Usuario buscarUsuarioQueMaisAssistiuVideos() {
        return queryService.buscarUsuarioQueMaisAssistiuVideos();
    }
}

