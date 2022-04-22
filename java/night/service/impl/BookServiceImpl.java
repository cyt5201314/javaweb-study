package night.service.impl;

import night.mapper.BookMapper;
import night.pojo.PageBean;
import night.pojo.Record;
import night.service.BookService;
import night.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author night520
 * @create 2022-04-15
 */
public class BookServiceImpl implements BookService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * get all records. return list
     * @return
     */
    @Override
    public List<Record> selectAll() {

        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        //call method to get all records
        List<Record> records = mapper.selectAll();

        sqlSession.close();
        return records;
    }

    /**
     * delete a record by id
     * @param id
     */
    @Override
    public void deleteById(int id) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        //call method to delete
        mapper.deleteById(id);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void add(Record record) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.add(record);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * update record
     * @param record
     */
    @Override
    public void update(Record record) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.update(record);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * query
     * @param record
     * @return
     */
    @Override
    public List<Record> selectByCondition(Record record) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        List<Record> records = mapper.selectByCondition(record);

        sqlSession.close();
        return records;
    }

    /**
     * delete selected
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * pagination
     * @param record
     * @param currentPage
     * @param size
     * @return
     */
    @Override
    public PageBean<Record> selectByConditionAndPage(Record record, int currentPage, int size) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        //page - 1
        currentPage = (currentPage - 1) * size;

        List<Record> records = mapper.selectByConditionAndPage(record, currentPage, size);
        int total = mapper.getTotal(record);

        PageBean<Record> pageBean = new PageBean<>();
        pageBean.setRows(records);
        pageBean.setTotal(total);

        sqlSession.close();
        return pageBean;
    }

    /**
     * get total count
     * @return
     */
    @Override
    public int getTotal(Record record) {
        //get mapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        int total = mapper.getTotal(record);

        sqlSession.close();
        return total;
    }
}
