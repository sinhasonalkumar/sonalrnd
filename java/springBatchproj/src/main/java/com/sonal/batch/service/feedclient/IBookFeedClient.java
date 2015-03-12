package com.sonal.batch.service.feedclient;

import java.util.List;

import com.sonal.batch.vo.BooksFeed;

public interface IBookFeedClient {

    List<BooksFeed> getBookFeed();

}