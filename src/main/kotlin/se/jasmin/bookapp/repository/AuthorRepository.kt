package se.jasmin.bookapp.repository

import se.jasmin.bookapp.repository.entity.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface AuthorRepository : JpaRepository<Author, Long>