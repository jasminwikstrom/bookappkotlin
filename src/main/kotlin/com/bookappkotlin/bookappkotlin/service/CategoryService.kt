package com.bookappkotlin.bookappkotlin.service


import com.bookappkotlin.bookappkotlin.controller.dto.AddCategoryDto
import com.bookappkotlin.bookappkotlin.repository.entity.Category


interface CategoryService {

    fun addCategory(addCategoryDto: AddCategoryDto): Category


}