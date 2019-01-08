package se.jasmin.bookapp.service

import org.springframework.stereotype.Service
import se.jasmin.bookapp.api.dto.AddAuthorDto
import se.jasmin.bookapp.repository.AuthorRepository
import se.jasmin.bookapp.repository.entity.Author


interface AuthorService {
    fun addAuthor(addAuthorDto: AddAuthorDto): Author
}

@Service
class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {

    override fun addAuthor(addAuthorDto: AddAuthorDto): Author {

        val author = Author(name = addAuthorDto.name, aboutAuthor = addAuthorDto.aboutAuthor)

        return authorRepository.save(author)
    }
}