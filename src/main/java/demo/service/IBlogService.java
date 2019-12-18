package demo.service;

import java.util.List;
import java.util.Map;

public interface IBlogService  {
    /**
     * 获取添加博文时的
     * @return
     */
    public Map<String,Object> queryAddBlogParam();

    /**
     * 根据id查询博文
     * @param id
     * @return
     */
    public Map<String,Object> queryBlogById(String id);

    /**
     * 获取所有符合条件的博文
     * @return
     */
    public List<Map<String,Object>> queryAllBlog();
}
