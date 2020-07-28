package org.liuc.item.service;

import org.liuc.item.mapper.CategoryMapper;
import org.liuc.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 根据父节点Id，查询子节点
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }

}
