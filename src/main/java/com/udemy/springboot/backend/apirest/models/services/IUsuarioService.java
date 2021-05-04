package com.udemy.springboot.backend.apirest.models.services;

import com.udemy.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
