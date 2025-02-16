package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "task")
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var title: String? = null

    @Column(nullable = false)
    var completed: Boolean? = null

    @Column
    var taskDate: java.time.LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "category_id")
    var category: Category? = null

    @ManyToOne
    @JoinColumn(name = "priority_id")
    var priority: Priority? = null

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null
}
