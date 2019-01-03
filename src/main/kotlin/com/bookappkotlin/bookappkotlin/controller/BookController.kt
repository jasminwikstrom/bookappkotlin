package com.bookappkotlin.bookappkotlin.controller

import com.bookappkotlin.bookappkotlin.model.Book
import com.bookappkotlin.bookappkotlin.model.CreateBookDto
import com.bookappkotlin.bookappkotlin.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid



@RestController
@RequestMapping("/books")
class BookController(private val bookRepository: BookRepository) {

    @GetMapping
    fun getAllBooks(): List<Book> =
            bookRepository.findAll()


    @PostMapping
    fun createNewBook(@Valid @RequestBody book: CreateBookDto): Book {
        val bookToCreate = Book(title = book.title, content = book.content)
        return bookRepository.save(bookToCreate)
    }


    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable(value = "id") bookId: Long): ResponseEntity<Void> {



        return bookRepository.findById(bookId).map { book  ->
            bookRepository.delete(book)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}
