package com.bookappkotlin.bookappkotlin.controller

import com.bookappkotlin.bookappkotlin.model.Book
import com.bookappkotlin.bookappkotlin.model.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid



@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllBooks(
            @RequestParam(value = "title", required = false) title: String?,
            @RequestParam(value = "content", required = false) content: String?): ResponseEntity<List<Book>> {

        val books = bookService.getAllBooks(title, content)

        return if (books.isNotEmpty())
            ResponseEntity.ok(books)
        else
            ResponseEntity.notFound().build()
    }


    @PostMapping
    fun createNewBook(@Valid @RequestBody createNewBookDto: CreateNewBookDto): Book {
        return bookService.createNewBook(createNewBookDto)
    }



 /*   @PutMapping("/{id}")
    fun updateBookById(@PathVariable(value = "id") bookId: Long,
                          @Valid @RequestBody newBook: Book): ResponseEntity<Book> {

        return bookRepository.findById(bookId).map { existingBook ->
            val updatedBook: Book = existingBook
                    .copy(title = newBook.title, content = newBook.content)
            ResponseEntity.ok().body(bookRepository.save(updatedBook))
        }.orElse(ResponseEntity.notFound().build())

    }


    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable(value = "id") bookId: Long): ResponseEntity<Void> {



        return bookRepository.findById(bookId).map { book  ->
            bookRepository.delete(book)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }*/
}
