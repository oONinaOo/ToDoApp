package ToDo.Model;

import java.util.List;

public interface ToDoDAO {
    List<Todo> getTodos();
    Todo getTodo(int ID);
    Todo addTodo (String name);
    void toggleStatus(int ID);
    void deleteTodo(int ID);

}
