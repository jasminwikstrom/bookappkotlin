package com.bookappkotlin.bookappkotlin.controller.dto

data class CreateNewBookDto(val title: String, val content: String, val authorId: String)

data class GetAllBooksDto(val id: String, val title: String, val content: String)

data class UpdateBookDto (val content: String?)

data class DeleteBookDto(val id: String, val title: String, val content: String)

data class AddAuthorDto(val name: String, val aboutAuthor: String)