package com.udemy.springboot.backend.apirest.models.dao;

import com.udemy.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository <Usuario,Long> {

    public Usuario findByUserName(String username);

    @Query("Select u from Usuario u where username=?1")
    public Usuario findByUserNameQuery (String userName);

}
