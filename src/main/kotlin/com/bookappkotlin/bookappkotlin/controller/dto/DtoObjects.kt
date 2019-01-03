package com.bookappkotlin.bookappkotlin.model

data class CreateNewBookDto(val title: String, val content: String)

data class GetAllBooksDto(val id: String, val title: String, val content: String)

data class UpdateBookDto (val content: String?)

data class DeleteBookDto(val id: String, val title: String, val content: String)
