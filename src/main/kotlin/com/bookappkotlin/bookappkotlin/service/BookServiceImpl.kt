package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.controller.dto.UpdateBookDto
import com.bookappkotlin.bookappkotlin.repository.AuthorRepository
import com.bookappkotlin.bookappkotlin.repository.BookRepository
import com.bookappkotlin.bookappkotlin.repository.entity.Book
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
        private val bookRepository: BookRepository,
        private val authorRepository: AuthorRepository) : BookService {


    //  FUNKAR MED BORTKOMDEL---->

    override fun updateBookById(id: Long, updateBookDto: UpdateBookDto): Book? {

        val foundBook = bookRepository.findById(id)

        return foundBook.map {
            it.content = updateBookDto.content ?: it.content
            bookRepository.save(it)
        }.orElse(null)
    }


/*

override fun updateBookById(id: Long, updateBookDto: UpdateBookDto): Book {
    val foundBook = bookRepository.findById(id).get()

    foundBook.copy(updateBookDto.id.toLong()).content





    return bookRepository.save(foundBook)
}

*/


    override fun deleteBookById(id: Long) {
        bookRepository.deleteById(id)
    }


    override fun getAllBooks(title: String?, content: String?): List<Book> {

        return bookRepository.findAll()
    }

    override fun createNewBook(createNewBookDto: CreateNewBookDto): Book {

        val author = authorRepository.findById(createNewBookDto.authorId.toLong())

        if (author.isEmpty) {
            throw IllegalArgumentException("Author not found")
        }

        val foundAuthor = author.get()

        val book = Book(
                title = createNewBookDto.title,
                content = createNewBookDto.content,
                author = foundAuthor)

        return bookRepository.save(book)
    }


}