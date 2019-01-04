package com.bookappkotlin.bookappkotlin.controller.dto



data class CreateNewBookDto(val title: String, val description: String, val authorId: String , val year: String , val categoryId: String)

data class GetAllBooksDto(val id: String, val title: String, val description: String)

data class UpdateBookDto (val description: String?)

data class DeleteBookDto(val id: String, val title: String, val description: String)

data class AddAuthorDto(val name: String, val aboutAuthor: String)

data class AddCategoryDto(val text: String)