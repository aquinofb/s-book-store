package com.felipe.web.views

import com.felipe.domain.bookshelf.Book

case class BookResponse(book: Book)

case class BookListResponse(books: Seq[Book])