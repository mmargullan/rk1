package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "activity")
class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var uuid: String? = null

    @Column(nullable = false)
    var activated: Boolean? = null

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    var user: User? = null
}
