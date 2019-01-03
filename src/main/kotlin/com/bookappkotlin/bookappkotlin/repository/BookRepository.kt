package com.bookappkotlin.bookappkotlin.repository


import com.bookappkotlin.bookappkotlin.repository.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long>


