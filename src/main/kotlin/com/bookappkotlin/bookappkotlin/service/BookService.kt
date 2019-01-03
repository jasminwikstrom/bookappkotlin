package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.model.Book
import com.bookappkotlin.bookappkotlin.model.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.model.DeleteBookDto
import com.bookappkotlin.bookappkotlin.model.UpdateBookDto

interface BookService {


        fun createNewBook(createNewBookDto: CreateNewBookDto): Book

        fun getAllBooks(title: String?, content: String?): List<Book>

        fun updateBookById(id: Long?, book: UpdateBookDto): Book

        fun deleteBookById(id: Long?, book: DeleteBookDto): Book
    }





