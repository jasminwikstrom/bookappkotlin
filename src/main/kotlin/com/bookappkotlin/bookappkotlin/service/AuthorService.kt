package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.AddAuthorDto
import com.bookappkotlin.bookappkotlin.repository.entity.Author


interface AuthorService {

    fun addAuthor(addAuthorDto: AddAuthorDto): Author


}