package se.jasmin.bookapp.repository


import se.jasmin.bookapp.repository.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

      @Query(value = "SELECT b FROM Book b " +
      "JOIN b.author a " +
      "JOIN b.category c " +
      "WHERE (:title IS NULL OR b.title = :title) " +
      "AND (:author IS NULL OR a.name = :author)")
 fun findByQuery(
              @Param("title") title:String?,
              @Param("author") author:String?):List<Book>
}




