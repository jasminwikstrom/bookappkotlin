package com.bookappkotlin.bookappkotlin.repository

import com.bookappkotlin.bookappkotlin.repository.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AuthorRepository : JpaRepository<Author, Long>