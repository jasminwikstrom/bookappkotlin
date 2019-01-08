package se.jasmin.bookapp.service

import org.springframework.stereotype.Service
import se.jasmin.bookapp.api.dto.CreateNewBookDto
import se.jasmin.bookapp.api.dto.UpdateBookDto
import se.jasmin.bookapp.repository.AuthorRepository
import se.jasmin.bookapp.repository.BookRepository
import se.jasmin.bookapp.repository.CategoryRepository
import se.jasmin.bookapp.repository.entity.Book

interface BookService {
    fun createNewBook(createNewBookDto: CreateNewBookDto): Book
    fun getAllBooks(title: String?, author: String?): List<Book>
    fun updateBookById(id: Long, updateBookDto: UpdateBookDto): Book?
    fun deleteBookById(id: Long): String?
}

@Service
class BookServiceImpl(
        private val bookRepository: BookRepository,
        private val authorRepository: AuthorRepository,
        private val categoryRepository: CategoryRepository) : BookService {

    override fun updateBookById(id: Long, updateBookDto: UpdateBookDto): Book? {

        val foundBook = bookRepository.findById(id)

        return foundBook.map {
            it.description = updateBookDto.description ?: it.description
            bookRepository.save(it)
        }.orElse(null)
    }

    override fun deleteBookById(id: Long): String? {

        val bookToDelete = bookRepository.findById(id)

        return bookToDelete.map {
            bookRepository.deleteById(it.id!!)
            it.id.toString()
        }.orElse(null)
    }

    override fun getAllBooks(title: String?, author: String?): List<Book> {
        return bookRepository.findByQuery(title = title, author = author)
    }

    override fun createNewBook(createNewBookDto: CreateNewBookDto): Book {

        val author = authorRepository.findById(createNewBookDto.authorId.toLong())

        if (author.isEmpty) {
            throw IllegalArgumentException("Author not found")
        }

        val foundAuthor = author.get()

        val category = categoryRepository.findById(createNewBookDto.categoryId.toLong())

        val foundCategory = category.get()

        val book = Book(
                title = createNewBookDto.title,
                description = createNewBookDto.description,
                author = foundAuthor,
                year = createNewBookDto.year,
                category = foundCategory)
        return bookRepository.save(book)
    }
}





