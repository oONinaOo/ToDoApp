package ToDo.Servlet;

import ToDo.Model.ToDoDAO;
import ToDo.Model.ToDoMem;
import ToDo.Model.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(name = "DeleteToDo")
public class DeleteToDo extends HttpServlet {
    ToDoDAO todoDao = ToDoMem.INSTANCE;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();

        JsonParser parser = new JsonParser();
        Object object = parser.parse(data);
        JsonArray array = (JsonArray) object;

        for (int i = 0; i < array.size(); i++) {
            ObjectMapper readDelete = new ObjectMapper();
            Todo delete = readDelete.readValue(array.get(i).toString(), Todo.class);
            todoDao.deleteTodo(delete.getID());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}