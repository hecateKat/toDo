package com.kat.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api"})
public class HelloServlet extends HttpServlet {

    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    private HelloService helloService;

    @SuppressWarnings("unused")
    public HelloServlet() {
        this(new HelloService());
    }

    public HelloServlet(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Got request with parameters" + req.getParameterMap());
        String name = req.getParameter(NAME_PARAM);
        String lang = req.getParameter(LANG_PARAM);
        Integer langId = null;
        try {
            langId = Integer.valueOf(lang);
        } catch (NumberFormatException e){
            logger.warn("Non-numeric language id used: " + lang);
        }
        resp.getWriter().write(helloService.prepareGreeting(name, langId));
    }
}
