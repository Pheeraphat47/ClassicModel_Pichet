package sit.int202.classicmodels.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", servletNames = {"ProductListServlet"})
public class LoggingFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long before = System.currentTimeMillis();
        //before invoke resources
        chain.doFilter(request, response);
        //after invoke resources
        long duration = System.currentTimeMillis() - before;
        String msg = "Resource: " + ((HttpServletRequest) request).getRequestURI() +
                ", execution time: "+ duration+ " milliSeconds";
        config.getServletContext().log(msg);
    }
    public void destroy() {
    }
}