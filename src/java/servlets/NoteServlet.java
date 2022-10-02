package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author ardee
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit");
        String title;
        String contents;

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        title = br.readLine();
        contents = br.readLine();
        br.close();

        Note note = new Note(title, contents);
        request.setAttribute("note", note);

        if (edit != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(title);
        pw.println(contents);
        pw.close();

        Note note = new Note(request.getParameter("title"), request.getParameter("content"));
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}
