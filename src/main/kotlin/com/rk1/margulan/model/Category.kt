package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "category")
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    @Column
    var completedCount: Long? = null

    @Column
    var uncompletedCount: Long? = null
}
