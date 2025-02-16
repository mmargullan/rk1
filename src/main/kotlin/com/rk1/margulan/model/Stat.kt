package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "stat")
class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var completedTotal: Long? = null

    @Column
    var uncompletedTotal: Long? = null

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    var user: User? = null
}
