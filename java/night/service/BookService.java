package night.service;

import night.pojo.PageBean;
import night.pojo.Record;

import java.util.List;

/**
 * @author night520
 * @create 2022-04-15
 */
public interface BookService {

    /**
     * get all records
     * @return
     */
    List<Record> selectAll();

    /**
     * delete a record by id
     * @param id
     */
    void deleteById(int id);

    /**
     * add record
     * @param record
     */
    void add(Record record);

    /**
     * update data
     * @param record
     */
    void update(Record record);

    /**
     * query
     * @param record
     * @return
     */
    List<Record> selectByCondition(Record record);

    /**
     * delete selected
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * pagination
     * @param record
     * @param currentPage
     * @param size
     * @return
     */
    PageBean<Record> selectByConditionAndPage(Record record, int currentPage, int size);

    /**
     * get total
     * @return
     */
    int getTotal(Record record);
}
