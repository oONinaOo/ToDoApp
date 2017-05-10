<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>TodoApp</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  </head>
  <body>
  <input type = "text" size="35" name="todo" id="todo" placeholder="What needs to be done?">
  <button id="add" onclick="addTodo()">Add to list</button>
  <div id="todoList" class="fadeOnLoad"></div>
  <button id = "all">All</button><button id="active">Active</button><button id = "completed">Completed</button><button id = "delete">Delete completed</button>
  <script type="text/javascript" src="script.js"></script>
  </body>
</html>
