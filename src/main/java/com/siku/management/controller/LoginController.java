package com.siku.management.controller;

import com.siku.management.Application;
import com.siku.management.mapper.BookMapper;
import com.siku.management.model.Book;
import com.siku.management.model.LoginUser;
import com.siku.management.mapper.LoginUserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luyaozhang on 2018/6/9.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginUserMapper loginUserMapper;
    @Autowired
    private BookMapper bookMapper;

    private static Logger logger = Logger.getLogger(Application.class);

    //HttpServletRequest request, HttpServletResponse response,
    @RequestMapping(value = "bookPage", method = RequestMethod.POST)
    public String bookPage(String username, String password, Model model) throws Exception {
        model.addAttribute("name", username.trim());
        //数据库里查看权限
        LoginUser loginUser = loginUserMapper.selectByPrimaryKey(username.trim());
        if (loginUser != null && loginUser.getPwd().equals(password.trim())) {
            //将数据存储到session中
            /*HttpSession session = request.getSession();
            session.setAttribute("loginUser", username.trim());
            String sessionId = session.getId();
            logger.info("sessionId=" + sessionId);*/
            //取数
            List<Book> bookList = new ArrayList<>();

            model.addAttribute("bookList",bookList);
            return "book";
            //response.sendRedirect("/books.html");
        }
        return "hello";
    }
}


