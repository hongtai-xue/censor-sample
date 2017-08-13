import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.Assert.assertEquals;
public class CensorServletTest {
    MockHttpServletResponse res = new MockHttpServletResponse();
    MockHttpServletRequest req = new MockHttpServletRequest();
    CensorServlet servlet = new CensorServlet();

    @Test
    public void simpleCensor() throws Exception {
        req.addParameter("headline", "some headline news");
        req.addParameter("censor-word", "some");

        servlet.doPost(req, res);

        assertEquals("**** headline news", req.getAttribute("censored-result"));
        assertEquals("/", res.getForwardedUrl());
    }

    @Test
    public void nullEntry() throws Exception {
        servlet.doPost(req, res);

        assertEquals("Please fill in headline and censored word", req.getAttribute("censored-result"));
        assertEquals("/", res.getForwardedUrl());
    }

    @Test
    public void emptyEntry() throws Exception {
        req.addParameter("headline", "");
        req.addParameter("censor-word", "");

        servlet.doPost(req, res);

        assertEquals("Please fill in headline and censored word", req.getAttribute("censored-result"));
        assertEquals("/", res.getForwardedUrl());
    }
}
