package ToDo;

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
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "DeleteToDo")
public class DeleteToDo extends HttpServlet {
    ToDoDAO todoDao = ToDoMem.INSTANCE;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        String data = buffer.toString();

        JsonParser parser = new JsonParser();
        Object object = parser.parse(data);
        JsonArray array = (JsonArray) object;

        List<DataManager> deleteList = new ArrayList<>();

        for (int i=0; i<array.size(); i ++){
            ObjectMapper readDelete = new ObjectMapper();
            DataManager delete = readDelete.readValue(array.get(i).toString(), DataManager.class);
            todoDao.deleteTodo(delete.getID());
        }





        //for (DataManager todo : todoDao.getTodos()){

          //  if (todo.getID() == deleteToDo.getID()){
              //  todoDao.deleteTodo(todo.getID());
               // System.out.println(todo.isActive());
            //}
        //}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}