package com.nicoletti.store.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nicoletti.store.enums.ClientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_telefone")
    private Set<String> phones = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();
}
