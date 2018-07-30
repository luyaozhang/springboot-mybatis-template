package com.siku.management.controller;

import com.siku.management.entity.SearchRequest;
import com.siku.management.mapper.BookMapper;
import com.siku.management.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by luyaozhang on 2018/6/9.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    private Logger logger = Logger.getLogger(DataController.class);

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value = "/book/edit", method = RequestMethod.POST)
    @ResponseBody
    public String editBook(HttpServletRequest request) {
        try {
            String id = request.getParameter("editId");
            String name = request.getParameter("editName").trim();
            String price = request.getParameter("editPrice").trim();
            String sellNum = request.getParameter("editSellNum").trim();
            Book newItem=bookMapper.selectByPrimaryKey(Long.parseLong(id));
            newItem.setName(name.trim());
            newItem.setPrice(Double.parseDouble(price.trim()));
            newItem.setSellnum(Integer.parseInt(sellNum.trim()));
            newItem.setDatachangeLasttime(new Date());
            bookMapper.updateByPrimaryKey(newItem);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/book/add/{newName}/{newPrice}/{newSellNum}", method = RequestMethod.POST)
    @ResponseBody
    public String addBook(@PathVariable String newName, @PathVariable String newPrice, @PathVariable String newSellNum) {
        try {
            Book newItem=new Book();
            newItem.setId(0L);
            newItem.setName(newName);
            newPrice=newPrice.replaceAll("。",",");
            newItem.setPrice(Double.parseDouble(newPrice.trim()));
            newItem.setSellnum(Integer.parseInt(newSellNum.trim()));
            newItem.setDatachangeLasttime(new Date());
            bookMapper.insert(newItem);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/book/load", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> getBookList() {
        try {
            return bookMapper.selectAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/book/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Book> searchBookList(@RequestBody SearchRequest request) {
        List<Book> returnList = new ArrayList<>();
        try {
            if ("".equals(request.getSearchIndexValue()))
                return this.getBookList();
            if (request.getSearchIndex() == 1) {
                Book item = bookMapper.selectByPrimaryKey(Long.parseLong(request.getSearchIndexValue()));
                if (item != null) {
                    returnList.add(item);
                    return returnList;
                }
            }
            if (request.getSearchIndex() == 2)
                return bookMapper.selectByName(request.getSearchIndexValue());
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return returnList;
    }

    @RequestMapping(value = "/book/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        try {
            int result = bookMapper.deleteByPrimaryKey(id);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
