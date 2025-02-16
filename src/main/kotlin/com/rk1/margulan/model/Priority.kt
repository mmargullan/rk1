package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "priority")
class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(nullable = false)
    var color: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null
}
