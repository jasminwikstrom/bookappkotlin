package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.CreateNewBookDto
import com.bookappkotlin.bookappkotlin.controller.dto.UpdateBookDto
import com.bookappkotlin.bookappkotlin.repository.entity.Book

interface BookService {


        fun createNewBook(createNewBookDto: CreateNewBookDto): Book

        fun getAllBooks(title: String?, content: String?): List<Book> //TODO ANVÄNDA DTO ELLER EJ?

        fun updateBookById(id: Long, updateBookDto: UpdateBookDto) : Book?


        fun deleteBookById(id: Long ) // TODO ANVÄNDA DTO ELLER EJ?



}





