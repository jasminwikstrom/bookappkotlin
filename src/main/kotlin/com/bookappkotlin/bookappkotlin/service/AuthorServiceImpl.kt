package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.AddAuthorDto
import com.bookappkotlin.bookappkotlin.repository.entity.Author
import com.bookappkotlin.bookappkotlin.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

override fun addAuthor(addAuthorDto: AddAuthorDto): Author {

    val author = Author(name = addAuthorDto.name, aboutAuthor = addAuthorDto.aboutAuthor)

    return authorRepository.save(author)
    }
}