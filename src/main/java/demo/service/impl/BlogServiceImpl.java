package demo.service.impl;

import demo.dao.IBlogDao;
import demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogDao blogDao;

    @Override
    public Map<String, Object> queryAddBlogParam() {
        return blogDao.queryAddBlogParam();
    }

    @Override
    public Map<String, Object> queryBlogById(String id) {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryAllBlog() {
        return null;
    }
}
