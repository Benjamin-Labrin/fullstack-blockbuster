package com.labrin.blockbuster.controller;

import com.labrin.blockbuster.model.Director;
import com.labrin.blockbuster.model.Pelicula;
import com.labrin.blockbuster.service.PeliculaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Injectmocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.hibernate.validator.constraints.Mod10Check;

@ExtendWith(MockitoExtension.class)
class PeliculaControllerTest{

    @Mock
    private PeliculaService peliculaService;

    @Injectmocks
    private PeliculaController peliculaController;

    @Test
    void crearPelicula_retorna201_cuandoExisteDirector(){

        Director director = new Director(1, "Antoine Fuqua", 60, "Estadounidense")
        Pelicula pelicula = new Pelicula(1 , "Michael", "Gk Films", 2026, director);

        when(peliculaService.savePelicula(pelicula)).thenReturn(pelicula);

        var respuesta = peliculaController.agregarPelicula(pelicula);

        assertNotNull(respuesta);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        var body = respuesta.getBody();
        assertNotNull(body);

        assertEqueals("Michael", body.getTitulo());
    }
}