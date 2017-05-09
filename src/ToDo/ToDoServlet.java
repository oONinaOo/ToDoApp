package ToDo;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;


public class ToDoServlet extends javax.servlet.http.HttpServlet {
    ToDoDAO todoDao = ToDoMem.INSTANCE;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        String name = buffer.toString();

        DataManager newTodo = todoDao.addTodo(name);
        todoDao.getTodos().add(newTodo);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ObjectMapper getList = new ObjectMapper();
        getList.writer().writeValue(response.getOutputStream(), todoDao.getTodos());

    }

}
