package no.hvl.dat110.rest.counters;

import okhttp3.MediaType;

public class PutRequest {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {
        /*
        Todos counters = new Todos(2, 4);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, counters.toJson());

        Request request = new Request.Builder().url("http://localhost:8080/counters").put(body).build();

        System.out.println(request.toString());

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    }
}