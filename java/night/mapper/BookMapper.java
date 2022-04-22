package night.mapper;

import night.pojo.Record;
import org.apache.ibatis.annotations.*;

import javax.swing.text.AbstractDocument;
import java.util.List;

/**
 * @author night520
 * @create 2022-04-15
 */
public interface BookMapper {

    /**
     * get all
     * @return
     */
    @Select("select * from account_book")
    @ResultMap("recordResultMap")
    List<Record> selectAll();

    /**
     * delete by id
     * @param id
     */
    @Delete("delete from account_book where id = #{id}")
    void deleteById(int id);

    /**
     * add record
     * @param record
     */
    @Insert("insert into account_book values (null,#{recordDate},#{category},#{amount},#{remark})")
    void add(Record record);

    /**
     * update
     * @param record
     */
    @Update("update account_book set record_date = #{recordDate},category = #{category},amount = #{amount},remark = #{remark} where id = #{id}")
    void update(Record record);

    /**
     * query
     * @param record
     * @return
     */
    List<Record> selectByCondition(@Param("record") Record record);

    /**
     * delete by ids
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * pagination
     * @param record
     * @return
     */
    List<Record> selectByConditionAndPage(@Param("record") Record record,@Param("currentPage") int currentPage,@Param("size") int size);

    /**
     * get total count
     * @return
     */
    int getTotal(@Param("record") Record record);
}
