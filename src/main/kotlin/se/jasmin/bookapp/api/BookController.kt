package se.jasmin.bookapp.api

import se.jasmin.bookapp.api.dto.AddAuthorDto
import se.jasmin.bookapp.api.dto.AddCategoryDto
import se.jasmin.bookapp.api.dto.CreateNewBookDto
import se.jasmin.bookapp.api.dto.UpdateBookDto
import se.jasmin.bookapp.repository.entity.Author
import se.jasmin.bookapp.repository.entity.Book
import se.jasmin.bookapp.repository.entity.Category
import se.jasmin.bookapp.service.AuthorService
import se.jasmin.bookapp.service.BookService
import se.jasmin.bookapp.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService, private val authorService: AuthorService, private val categoryService: CategoryService) {

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

    @PostMapping("/authors")
    fun addAuthor(@RequestBody addAuthorDto: AddAuthorDto): Author {

        return authorService.addAuthor(addAuthorDto)
    }

    @PostMapping("/categories")
    fun addCategory(@RequestBody addCategoryDto: AddCategoryDto): Category {
        return categoryService.addCategory(addCategoryDto)
    }

    @PostMapping
    fun createNewBook(@Valid @RequestBody createNewBookDto: CreateNewBookDto): Book {
        return bookService.createNewBook(createNewBookDto)
    }

    @PutMapping("/{id}")
    fun updateBookById(
            @PathVariable(value = "id") id: Long,
            @Valid @RequestBody updateBookDto: UpdateBookDto): ResponseEntity<Book>? {

        val updatedBook = bookService.updateBookById(id, updateBookDto)

        return if (updatedBook != null) ResponseEntity.ok().body(updatedBook) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable("id") id: Long): ResponseEntity<String> {
        val deletedBookId = bookService.deleteBookById(id)

        return if (deletedBookId != null) ResponseEntity.ok(deletedBookId) else ResponseEntity.notFound().build()
    }
}
