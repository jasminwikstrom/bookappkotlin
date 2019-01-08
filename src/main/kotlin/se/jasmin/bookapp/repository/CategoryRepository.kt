package se.jasmin.bookapp.repository


import se.jasmin.bookapp.repository.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>


