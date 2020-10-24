package lk.ijse.webservice.resource_access.servlet;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import lk.ijse.webservice.resource_access.modal.Chat;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;

public class ChatSend extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String s = CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));


        Chat chat = new Gson().fromJson(s, Chat.class);
        chat.setTime(new Timestamp(System.currentTimeMillis()).toString());

        ArrayList<Chat> chatStore = (ArrayList<Chat>) getServletContext().getAttribute("chatStore");
        if (chatStore == null) {
            ArrayList<Chat> objects = new ArrayList<>();
            objects.add(chat);
            getServletContext().setAttribute("chatStore", objects);
        } else {
            chatStore.add(chat);
        }
    }
}
