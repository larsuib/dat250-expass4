package no.hvl.dat110.rest.counters;

import static spark.Spark.*;

/**
 * Hello world!
 */
public class App {

    static Todos todos = null;

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        todos = new Todos();

        after((req, res) -> {
            res.type("application/json");
        });

        get("/hello", (req, res) -> "Hello World!");

        // Read
        get("/todos", (req, res) -> todos.toJson());
        get("/todos/:id", (req, res) -> todos.getTodo(Long.parseLong(req.params("id"))).toJson());

        // Create
        post("/todos", (req, res) -> todos.add(req.body()));  //auto-index
        post("/todos/:id", (req, res) -> todos.add(req.body(), Long.parseLong(req.params("id"))));

        // Update
        put("/todos/:id", (req, res) -> todos.updateTodo(req.body(), Long.parseLong(req.params(":id"))));
        put("/todos/:id/:field", (req, res) -> todos.updateTodo(Long.parseLong(req.params("id")), req.params("field"), req.body()));

        // Delete
        delete("/todos/:id", (req, res) -> todos.deleteTodo(Long.parseLong(req.params(":id"))));
    }

}
