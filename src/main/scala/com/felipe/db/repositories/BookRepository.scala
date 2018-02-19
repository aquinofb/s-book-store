package com.felipe.db.repositories

import com.felipe.db.tables.BookTable
import com.felipe.domain.bookshelf.Book
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

import scala.concurrent.{ExecutionContext, Future}

case class BookRepository(implicit db: Database, ec: ExecutionContext) {

  def all: Future[Seq[Book]] = db.run(books.result)

  def create(book: Book): Future[Book] = db.run(books returning books += book)

  def getByTitle(title: String): Future[Option[Book]] =
    db.run(books.filter(_.title === title).result.headOption)

  def delete(id: Long): Future[Int] = db.run(books.filter(_.id === id).delete)

  lazy val books = TableQuery[BookTable]
}
