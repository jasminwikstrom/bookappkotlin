package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.model.Book
import com.bookappkotlin.bookappkotlin.model.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.model.DeleteBookDto
import com.bookappkotlin.bookappkotlin.model.UpdateBookDto
import com.bookappkotlin.bookappkotlin.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(private val bookRepository: BookRepository) : BookService {


    override fun updateBookById(id: Long?, book: UpdateBookDto): Book {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteBookById(id: Long?, book: DeleteBookDto): Book {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllBooks(title: String?, content: String?): List<Book> {

        return bookRepository.findAll()
    }

    override fun createNewBook(createNewBookDto: CreateNewBookDto): Book {

        val book = Book(title = createNewBookDto.title, content = createNewBookDto.content)

        return bookRepository.save(book)
    }


}