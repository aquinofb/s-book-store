package com.felipe.db.tables

import java.sql.Date

import com.felipe.domain.bookshelf.Book
import slick.jdbc.PostgresProfile.api._

class BookTable(tag: Tag) extends Table[Book](tag, "books") {
  val id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  val title = column[String]("title")
  def releaseDate = column[Date]("release_date")
  def categoryId = column[Long]("category_id")
  def quantity = column[Int]("quantity")
  def author = column[String]("author")

  def * = (id, title, releaseDate, categoryId, quantity, author) <> ((Book.apply _).tupled, Book.unapply)
}
