package com.felipe.db.repositories

import com.felipe.db.tables.CategoryTable
import com.felipe.domain.bookshelf.Category
import slick.jdbc.PostgresProfile.api._
import slick.lifted.TableQuery

import scala.concurrent.{ExecutionContext, Future}

case class CategoryRepository(implicit db: Database, ec: ExecutionContext) {

  def all: Future[Seq[Category]] = db.run(categories.result)

  def create(category: Category): Future[Category] = db.run(categories returning categories += category)

  def getByTitle(title: String): Future[Option[Category]] =
    db.run(categories.filter(_.title === title).result.headOption)

  def delete(id: Long): Future[Int] = db.run(categories.filter(_.id === id).delete)

  lazy val categories = TableQuery[CategoryTable]
}
