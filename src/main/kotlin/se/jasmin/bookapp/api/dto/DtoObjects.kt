package se.jasmin.bookapp.api.dto

data class CreateNewBookDto(
        val title: String,
        val description: String,
        val authorId: String,
        val year: String,
        val categoryId: String)

data class UpdateBookDto(val description: String?)

data class AddAuthorDto(val name: String, val aboutAuthor: String)

data class AddCategoryDto(val text: String)