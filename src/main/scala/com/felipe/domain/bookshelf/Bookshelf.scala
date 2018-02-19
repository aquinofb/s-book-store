package com.felipe.domain.bookshelf

import com.felipe.db.repositories.{BookRepository, CategoryRepository}

import scala.concurrent.Future

case class Bookshelf(implicit bookRepository: BookRepository, categoryRepository: CategoryRepository) {

  def getAllBooks: Future[Seq[Book]] = bookRepository.all
}