package org.liuc.item.controller;

import org.liuc.item.pojo.Category;
import org.liuc.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 根据父节点Id，查询子节点
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid", defaultValue = "0")Long pid) {
        if (pid == null || pid < 0) {
            //400：参数不合法
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();     //法一
            //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);      //法二
            return ResponseEntity.badRequest().build();     //法三
        }
        List<Category> categoryList = this.categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categoryList)) {
            //404：未找到资源服务器
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return ResponseEntity.notFound().build();
        }
        //200：查询成功
        return ResponseEntity.ok(categoryList);
    }
}
