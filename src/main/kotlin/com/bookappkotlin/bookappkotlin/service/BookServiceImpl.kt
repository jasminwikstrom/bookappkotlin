package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.controller.dto.UpdateBookDto
import com.bookappkotlin.bookappkotlin.repository.AuthorRepository
import com.bookappkotlin.bookappkotlin.repository.BookRepository
import com.bookappkotlin.bookappkotlin.repository.CategoryRepository
import com.bookappkotlin.bookappkotlin.repository.entity.Book
import org.springframework.stereotype.Service

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





    override fun deleteBookById(id: Long) {
        bookRepository.deleteById(id)
    }


    override fun getAllBooks(title: String?, author: String?): List<Book> {

        return bookRepository.findByQuery(title = title,author = author)
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