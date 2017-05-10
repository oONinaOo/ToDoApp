package ToDo.Servlet;


import ToDo.Model.ToDoDAO;
import ToDo.Model.ToDoMem;
import ToDo.Model.Todo;
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

        Todo newTodo = todoDao.addTodo(name);
        todoDao.getTodos().add(newTodo);

        int sizeOfTodos = todoDao.getTodos().size();

        ObjectMapper getList = new ObjectMapper();
        getList.writer().writeValue(response.getOutputStream(), todoDao.getTodo(sizeOfTodos));

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ObjectMapper getList = new ObjectMapper();
        getList.writer().writeValue(response.getOutputStream(), todoDao.getTodos());

    }

}
