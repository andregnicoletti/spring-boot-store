package com.nicoletti.store.entities;

import com.nicoletti.store.enums.ClientType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    private ClientType client;

    @ElementCollection
    @CollectionTable(name = "tb_telefone")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Address> addresses = new HashSet<>();
}
