package ToDo;

import java.util.List;

public interface ToDoDAO {
    List<DataManager> getTodos();
    DataManager getTodo(int ID);
    DataManager addTodo (String name);
    void toggleStatus(int ID);
    void deleteTodo(int ID);

}
