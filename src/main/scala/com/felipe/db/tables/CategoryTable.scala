package com.felipe.db.tables

import com.felipe.domain.bookshelf.Category
import slick.jdbc.PostgresProfile.api._

class CategoryTable(tag: Tag) extends Table[Category](tag, "categories") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")

  override def * = (id, title) <> ((Category.apply _).tupled, Category.unapply)
}
