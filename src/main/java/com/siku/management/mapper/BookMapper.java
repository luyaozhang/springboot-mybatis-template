package com.siku.management.mapper;

import com.siku.management.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectAll();

    Book selectByPrimaryKey(Long id);

    List<Book> selectByName(String name);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}