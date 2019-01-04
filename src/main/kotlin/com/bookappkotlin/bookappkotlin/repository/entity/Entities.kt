package com.bookappkotlin.bookappkotlin.repository.entity



import javax.persistence.*


@Entity
@Table(name = "BOOK")
data class Book(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "AUTHOR_ID")
        val author: Author,


        @ManyToOne
        @JoinColumn(name = "CATEGORY_ID")
       var category: Category,

        var title: String,

        @Column(name = "DESCRIPTION")
        var description: String ,

        @Column(name = "YEAR")
        val year: String
)



@Entity
@Table(name = "CATEGORY")
data class Category(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        val id: Long? = null,


        val text: String
)


@Entity
@Table(name = "AUTHOR")
data class Author(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        val id: Long? = null,

        val name: String,

        val aboutAuthor: String
)


