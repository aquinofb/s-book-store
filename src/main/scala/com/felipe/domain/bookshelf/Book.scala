package com.felipe.domain.bookshelf

import java.sql.Date

import slick.jdbc.PostgresProfile.api._

case class Book(
  id: Option[Long] = None,
  title: String,
  releaseDate: Date,
  categoryId: Long,
  quantity: Int,
  author: String
)
