package se.jasmin.bookapp.repository


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import se.jasmin.bookapp.repository.entity.Category

@Repository
interface CategoryRepository : JpaRepository<Category, Long>


