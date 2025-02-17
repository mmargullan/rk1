package com.rk1.margulan.model

import javax.persistence.*

@Entity
@Table(name = "user_data", uniqueConstraints = [
    UniqueConstraint(name = "email_uniq", columnNames = ["email"]),
    UniqueConstraint(name = "username_uniq", columnNames = ["username"])
])
class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var email: String? = null

    @Column(nullable = false, name = "userpassword")
    var password: String? = null

    @Column(nullable = false)
    var username: String? = null

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: Set<Role>? = null

}