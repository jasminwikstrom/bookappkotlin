package com.bookappkotlin.bookappkotlin.model

data class CreateBookDto(val title: String, val content: String)

data class GetBookDto(val id: String, val title: String, val content: String)