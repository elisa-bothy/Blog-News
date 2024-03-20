/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elisa Bothy
 */
@WebFilter("/user/*")
public class userConnected implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //travail en amont
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        if(session == null || session.getAttribute("user") == null){
            ((HttpServletResponse)response).sendError(403);
        }else{
            //appel filtre suivant
            chain.doFilter(request, response);
            //travail en aval : rien
        }
    }

    @Override
    public void destroy() {
    }

}

