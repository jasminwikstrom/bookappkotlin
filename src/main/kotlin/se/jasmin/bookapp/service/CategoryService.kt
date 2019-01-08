package se.jasmin.bookapp.service


import org.springframework.stereotype.Service
import se.jasmin.bookapp.api.dto.AddCategoryDto
import se.jasmin.bookapp.repository.CategoryRepository
import se.jasmin.bookapp.repository.entity.Category

interface CategoryService {
    fun addCategory(addCategoryDto: AddCategoryDto): Category
}

@Service
class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {

    override fun addCategory(addCategoryDto: AddCategoryDto): Category {

        val category = Category(text = addCategoryDto.text)
        return categoryRepository.save(category)
    }
}