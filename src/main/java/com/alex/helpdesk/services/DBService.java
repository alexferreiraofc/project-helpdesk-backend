package com.alex.helpdesk.services;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.domain.Tecnico;
import com.alex.helpdesk.domain.enums.Perfil;
import com.alex.helpdesk.domain.enums.Prioridade;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositories.ChamadoRepository;
import com.alex.helpdesk.repositories.ClienteRepository;
import com.alex.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Alex", "35715835070", "alex@email.com", "123", null);
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "94229796099", "torvalds@mail.com", "123", null);

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));

    }
}
