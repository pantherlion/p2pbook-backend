package com.controller;

import com.model.Book;
import com.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/",produces = "application/json;charset=UTF-8")
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/add-book")
    public Map<String,String> addBook(@RequestBody Book book){
        int rows = repositoryService.addBook(book);

        Map<String,String> resultMap=new HashMap<>();
        if(rows==-1){
            //插入失败
            resultMap.put("result","fail");
        }
        else{
            resultMap.put("result","success");
        }
        return resultMap;
    }

    @RequestMapping("/show-allbook-exceptSelf")
    public List<Book> showAllBooksExceptSelf(){
        return repositoryService.showAllBooksExceptSelf();
    }

    @RequestMapping("/show-mybook")
    public List<Book> getMyBooks(){
        return repositoryService.showMyBooks();
    }
}
