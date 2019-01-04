package com.bookappkotlin.bookappkotlin.repository


import com.bookappkotlin.bookappkotlin.repository.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>


