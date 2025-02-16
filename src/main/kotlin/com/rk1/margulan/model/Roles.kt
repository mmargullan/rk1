package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "role_data")
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

}