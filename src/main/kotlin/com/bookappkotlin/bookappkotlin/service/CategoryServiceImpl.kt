package com.bookappkotlin.bookappkotlin.service

import com.bookappkotlin.bookappkotlin.controller.dto.AddCategoryDto
import com.bookappkotlin.bookappkotlin.repository.CategoryRepository
import com.bookappkotlin.bookappkotlin.repository.entity.Category
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {

    override fun addCategory(addCategoryDto: AddCategoryDto): Category {

        val category = Category(text = addCategoryDto.text)

        return categoryRepository.save(category)
    }
}