import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CensorServlet", urlPatterns = {"censor"})
public class CensorServlet extends HttpServlet {

    private final Censorer censorer = new Censorer();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String headline = request.getParameter("headline");
        String word = request.getParameter("censor-word");

        if(headline == null || word == null || "".equals(headline) || "".equals(word)) {
            request.setAttribute("censored-result", "Please fill in headline and censored word");
            request.getRequestDispatcher("/").forward(request, response);
            return;
        }

        String censoredHeadline = censorer.bleep(headline, word);

        request.setAttribute("censored-result", censoredHeadline);
        request.getRequestDispatcher("/").forward(request, response);
    }

}

