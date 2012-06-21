package org.springframework.samples.jpetstore.web.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.samples.jpetstore.domain.GitRepositoryState;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Anton Panasenko
 */

public class GitController implements Controller {

    @Autowired
    GitRepositoryState gitRepoState;

    public ModelAndView render(Object model, HttpServletResponse response)
    {
        MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();

        MediaType jsonMimeType = MediaType.APPLICATION_JSON;


        try {
            jsonConverter.write(model, jsonMimeType, new ServletServerHttpResponse(response));
        } catch (HttpMessageNotWritableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return render(gitRepoState, response);
    }

    public GitRepositoryState getGitRepoState() {
        return gitRepoState;
    }

    public void setGitRepoState(GitRepositoryState gitRepoState) {
        this.gitRepoState = gitRepoState;
    }
}