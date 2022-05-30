package com.alex.helpdesk.services;

import com.alex.helpdesk.domain.Chamado;
import com.alex.helpdesk.domain.Cliente;
import com.alex.helpdesk.domain.Tecnico;
import com.alex.helpdesk.domain.enums.Perfil;
import com.alex.helpdesk.domain.enums.Prioridade;
import com.alex.helpdesk.domain.enums.Status;
import com.alex.helpdesk.repositories.ChamadoRepository;
import com.alex.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Alex", "35715835070", "alex@email.com", "123", null);
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "John", "35715833070","john@mail.com","123",null);
        Tecnico tec3 = new Tecnico(null, "Bruce", "35722835070","bruce@mail.com","123", null);
        Tecnico tec4 = new Tecnico(null, "Edgar", "32315835070","edgar@mail.com","123",null);
        Tecnico tec5 = new Tecnico(null, "Roosie", "35715835990","rosie@mail.com","123",null);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "94229796099", "torvalds@mail.com", "123", null);
        Cliente cli2 = new Cliente(null, "albert", "93329796099", "albert@mail.com", "123",null);
        Cliente cli3 = new Cliente(null, "marie", "94229796779", "marie@mail.com", "123",null);
        Cliente cli4 = new Cliente(null, "charles", "94229796000", "charles@mail.com", "123",null);
        Cliente cli5 = new Cliente(null, "max planck", "94229476099", "max@mail.com", "123",null);

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 7", tec1, cli5);

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

    }
}
