package ToDo.Servlet;

import ToDo.Model.ToDoDAO;
import ToDo.Model.ToDoMem;
import ToDo.Model.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "UpdateStatus")
public class UpdateStatus extends HttpServlet {
    ToDoDAO todoDao = ToDoMem.INSTANCE;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        String data = buffer.toString();

        ObjectMapper readChange = new ObjectMapper();
        Todo change = readChange.readValue(data, Todo.class);
        for (Todo todo : todoDao.getTodos()){
            if (todo.getID() == change.getID()){
                todoDao.toggleStatus(todo.getID());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
