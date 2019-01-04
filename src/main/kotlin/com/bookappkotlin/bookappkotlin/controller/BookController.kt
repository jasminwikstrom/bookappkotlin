package com.bookappkotlin.bookappkotlin.controller

import com.bookappkotlin.bookappkotlin.controller.dto.AddAuthorDto
import com.bookappkotlin.bookappkotlin.controller.dto.AddCategoryDto
import com.bookappkotlin.bookappkotlin.controller.dto.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.controller.dto.UpdateBookDto
import com.bookappkotlin.bookappkotlin.repository.entity.Author
import com.bookappkotlin.bookappkotlin.repository.entity.Book
import com.bookappkotlin.bookappkotlin.repository.entity.Category
import com.bookappkotlin.bookappkotlin.service.AuthorService
import com.bookappkotlin.bookappkotlin.service.BookService
import com.bookappkotlin.bookappkotlin.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService, private val authorService: AuthorService, private val categoryService: CategoryService ) {

    @GetMapping
    fun getAllBooks(
            @RequestParam(value = "title", required = false) title: String?,
            @RequestParam(value = "author", required = false) author: String?): ResponseEntity<List<Book>> {

        val books = bookService.getAllBooks(title, author)

        return if (books.isNotEmpty())
            ResponseEntity.ok(books)
        else
            ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createNewBook(@Valid @RequestBody createNewBookDto: CreateNewBookDto): Book {
        return bookService.createNewBook(createNewBookDto)
    }


    @PostMapping("/authors")
    fun addAuthor(@RequestBody addAuthorDto: AddAuthorDto): Author {

        return authorService.addAuthor(addAuthorDto)
    }

    @PostMapping("/categories")
    fun addCategory(@RequestBody addCategoryDto: AddCategoryDto): Category {

        return categoryService.addCategory(addCategoryDto)
    }

    @PutMapping("/{id}")
    fun updateBookById(
            @PathVariable(value = "id") id: Long,
            @Valid @RequestBody updateBookDto: UpdateBookDto): ResponseEntity<Book>? {

        val updatedBook = bookService.updateBookById(id, updateBookDto)

        return if (updatedBook != null) ResponseEntity.ok().body(updatedBook) else ResponseEntity.notFound().build()
    }


    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable("id") id: Long) {
        bookService.deleteBookById(id)
    }




}
