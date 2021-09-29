package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Todos {

    private ArrayList<Todo> todos;

    public Todos() {
        this.todos = new ArrayList<>();

        this.todos.add(new Todo(new Long(0), "Summary", "Desc"));
    }

    private Integer todoIdToArrayId(Long todoId) {
        Integer i = 0;
        for (Todo t : todos) {
            if (t.getId().equals(todoId)) {
                System.out.println("Todo with id: " + todoId + " has index " + todos.indexOf(t) + " in array");
                return todos.indexOf(t);
            }
        }
        return null;
    }

    public String deleteTodo(Long id) {
        Integer index = todoIdToArrayId(id);
        Todo todo = todos.get(index);
        System.out.println(this.toJson());
        todos.remove((int) index);
        System.out.println(this.toJson());
        return todo.toJson();
    }

    public String add(String todoObj) {
        Gson gson = new Gson();
        Todo todo = gson.fromJson(todoObj, Todo.class);
        todos.add(todo);
        return todo.toJson();
    }

    public String add(String todoObj, Long id) {
        Gson gson = new Gson();
        Todo todo = gson.fromJson(todoObj, Todo.class);
        todo.setId(id);
        todos.add(todo);
        return todo.toJson();
    }

    public String updateTodo(String newTodo, Long id) {
        Gson gson = new Gson();
        Todo todo = gson.fromJson(newTodo, Todo.class);
        todos.set(todoIdToArrayId(id), todo);
        return todo.toJson();
    }

    public String updateTodo(Long id, String field, Object fieldValue) {
        Todo todo = todos.get(todoIdToArrayId(id));

        switch (field) {
            case "id":
                String newVal = (String) fieldValue;
                newVal.strip();
                System.out.println(newVal);
                todo.setId(Long.parseLong(newVal));
                break;

            case "summary":
                todo.setSummary((String) fieldValue);
                break;

            case "description":
                todo.setDescription((String) fieldValue);
                break;
        }
        return todo.toJson();
    }

    public Todo getTodo(Long id) {
        try {
            return todos.get(todoIdToArrayId(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    String toJson() {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }
}

class Todo {

    private Long id;
    private String summary;
    private String description;

    public Todo() {
        this.id = null;
        this.summary = null;
        this.description = null;
    }

    public Todo(Long id, String summary, String description) {
        this.id = id;
        this.summary = summary;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJson() {

        Gson gson = new Gson();

        String jsonInString = gson.toJson(this);

        return jsonInString;
    }
}

