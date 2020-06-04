package com.kat.lang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kat.hello.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Lang", urlPatterns = {"/api/langs"})
public class LangServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangRepository langRepository;
    private ObjectMapper objectMapper;

    private HelloService helloService;

    @SuppressWarnings("unused")
    public LangServlet() {
        this(new LangRepository(), new ObjectMapper());
    }

    public LangServlet(LangRepository langRepository, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.langRepository = langRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Got request with parameters" + req.getParameterMap());
        resp.setContentType("application/json;charset=UTF-8");
        objectMapper.writeValue(resp.getOutputStream(), langRepository.findAll());
    }
}