package br.com.mrlrsx.dsmovie.dto;

import br.com.mrlrsx.dsmovie.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;

    public UserDTO(){}

    public UserDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    public UserDTO(User entity){
        this(entity.getId(), entity.getEmail());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
