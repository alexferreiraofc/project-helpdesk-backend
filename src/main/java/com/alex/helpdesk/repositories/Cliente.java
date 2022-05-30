package com.alex.helpdesk.repositories;

import com.alex.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cliente extends JpaRepository<Tecnico, Integer> {
}
