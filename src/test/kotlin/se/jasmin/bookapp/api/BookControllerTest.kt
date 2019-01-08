package se.jasmin.bookapp.api

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import se.jasmin.bookapp.api.dto.AddAuthorDto
import se.jasmin.bookapp.api.dto.AddCategoryDto
import se.jasmin.bookapp.api.dto.CreateNewBookDto
import se.jasmin.bookapp.api.dto.UpdateBookDto
import se.jasmin.bookapp.repository.AuthorRepository
import se.jasmin.bookapp.repository.BookRepository
import se.jasmin.bookapp.repository.CategoryRepository
import se.jasmin.bookapp.repository.entity.Book


@RunWith(SpringRunner::class)
@SpringBootTest
class BookControllerTest {

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    @Autowired
    private lateinit var bookController: BookController

    @Before
    fun cleanDb() {
        bookRepository.deleteAll()
        categoryRepository.deleteAll()
        authorRepository.deleteAll()
    }

    @Test
    fun createNewBook() {

        //Assert that there are no books in repo

        val allBooks = bookController.getAllBooks(null, null)

        Assert.assertEquals(404, allBooks.statusCodeValue)
        Assert.assertNull(allBooks.body)

        val createdBook = createBookAndAuthorAndCategory()

        Assert.assertNotNull(createdBook)
        Assert.assertEquals("bra bok", createdBook.title)
        Assert.assertEquals("bra beskrivning", createdBook.description)
        Assert.assertEquals("2001", createdBook.year)
        Assert.assertEquals("skräckis", createdBook.category.text)
        Assert.assertEquals("bra Författare", createdBook.author.name)

        val getAllBooks = bookController.getAllBooks(null, null)

        Assert.assertNotNull(getAllBooks)
        Assert.assertNotNull(getAllBooks.body)
        Assert.assertEquals(1, getAllBooks.body!!.size)
    }


    @Test
    fun updateBookById() {

        val createdBook = createBookAndAuthorAndCategory()
        Assert.assertEquals("bra beskrivning", createdBook.description)

        val updateBookDto = UpdateBookDto(description = "ny beskrivning")

        val response = bookController.updateBookById(createdBook.id!!, updateBookDto)
        val updatedBook = response!!.body as Book

        Assert.assertEquals("ny beskrivning", updatedBook.description)


    }


    @Test
    fun updateBookByIdNullDescriptionShouldNotChange() {

        val createdBook = createBookAndAuthorAndCategory()
        Assert.assertEquals("bra beskrivning", createdBook.description)

        val updateBookDto = UpdateBookDto(description = null)

        val response = bookController.updateBookById(createdBook.id!!, updateBookDto)
        val updatedBook = response!!.body as Book

        Assert.assertEquals("bra beskrivning", updatedBook.description)


    }


    @Test
    fun deleteById() {

        val createdBook = createBookAndAuthorAndCategory()
        var allBooks = bookController.getAllBooks(null, null)
        Assert.assertEquals(1, allBooks.body!!.size)

        val deletedId = bookController.deleteBookById(createdBook.id!!)
        Assert.assertEquals(createdBook.id.toString(), deletedId.body)

        allBooks = bookController.getAllBooks(null, null)

        Assert.assertNull(allBooks.body)
        Assert.assertEquals(404, allBooks.statusCodeValue)
    }

    @Test
    fun deleteByIncorrectId() {
        val createdBook = createBookAndAuthorAndCategory()
        var allBooks = bookController.getAllBooks(null, null)

        val incorrectId = bookController.deleteBookById(17L)
        Assert.assertNull(createdBook.id.toString(), incorrectId.body)
        Assert.assertEquals(404, incorrectId.statusCodeValue)
        Assert.assertEquals(1, allBooks.body!!.size)

    }


    private fun createBookAndAuthorAndCategory(): Book {

        //Add a new Author and save in repo
        val addAuthorDto = AddAuthorDto(name = "bra Författare", aboutAuthor = "jätte bra")
        val addedAuthor = bookController.addAuthor(addAuthorDto)

        //Add a new Category and save in repo
        val addCategoryDto = AddCategoryDto(text = "skräckis")
        val addedCategory = bookController.addCategory(addCategoryDto)

        val createNewBookDto = CreateNewBookDto(
                authorId = addedAuthor.id.toString(),
                categoryId = addedCategory.id.toString(),
                description = "bra beskrivning",
                title = "bra bok",
                year = "2001"
        )

        return bookController.createNewBook(createNewBookDto)
    }

}




