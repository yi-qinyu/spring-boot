package demo.dao.impl;

import demo.dao.IBlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class BlogDaoImpl implements IBlogDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> queryAddBlogParam() {
        Map<String ,Object> result = new HashMap<>();
        String queryBwfl = "select  id,bwfldm,bwflmc from t_bwfl order by pxsx asc";
        result.put("bwfl",jdbcTemplate.queryForList(queryBwfl));
        return result;
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
