package night.web.servlets;
/**
 * @author night520
 * @create 2022-04-15
 */

import com.alibaba.fastjson.JSON;
import night.pojo.PageBean;
import night.pojo.Record;
import night.service.BookService;
import night.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/record/*")
public class RecordServlet extends BaseServlet {

    BookService service = new BookServiceImpl();

    /**
     * get all records and send them to front
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get list and convert to json
        List<Record> records = service.selectAll();
        String jsonString = JSON.toJSONString(records);
        response.setContentType("text/json;charset=utf-8");

        //send to front
        response.getWriter().write(jsonString);
    }

    /**
     * delete record
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get id from front and call method
        String id = request.getParameter("id");
        service.deleteById(Integer.parseInt(id));

        response.getWriter().write("delete success");
    }

    /**
     * add
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get object
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Record record = JSON.parseObject(params, Record.class);

        service.add(record);

        response.getWriter().write("add success");
    }

    /**
     * update record
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get object
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Record record = JSON.parseObject(params, Record.class);

        service.update(record);

        response.getWriter().write("update success");
    }

    /**
     * query
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get object
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Record record = JSON.parseObject(params, Record.class);

        List<Record> records = service.selectByCondition(record);

        String jsonString = JSON.toJSONString(records);
        response.setContentType("text/json;charset=utf-8");

        //send to front
        response.getWriter().write(jsonString);
    }

    /**
     * delete selected
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get ids
        BufferedReader reader = request.getReader();
        String param = reader.readLine();
        int[] ids = JSON.parseObject(param, int[].class);

        service.deleteByIds(ids);

        response.getWriter().write("delete success");
    }

    /**
     * pagination
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByConditionAndPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get object
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Record record = JSON.parseObject(params, Record.class);

        //get page and size
        String currentPage = request.getParameter("currentPage");
        String size = request.getParameter("size");

        //get database data
        PageBean<Record> pageBean = service.selectByConditionAndPage(record, Integer.parseInt(currentPage), Integer.parseInt(size));

        //translate to json
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");

        //send to front
        response.getWriter().write(jsonString);
    }
}
