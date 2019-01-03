package com.bookappkotlin.bookappkotlin.repository.entity

import javax.persistence.*


@Entity
data class Book(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "AUTHOR_ID")
        val author: Author,

        var title: String,

        var content: String
)

@Entity
data class Author(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        val name: String,

        val aboutAuthor: String
)


