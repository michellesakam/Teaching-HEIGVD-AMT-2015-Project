package ch.heigvd.amt.gamification.filters;

import ch.heigvd.amt.gamification.model.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class implements the Filter interface defined in the Servlet API. A
 * filter is a component that is placed in the (HTTP) request processing
 * pipeline. It can inspect and manipulate both the request (on the way in) and
 * the response (on the way out).
 *
 * The responsibility of this class is to handle authorization of HTTP requests
 * issued by clients. The security policy is defined as follows: - all pages of
 * the application are protected and can be accessed only if the the user has
 * successfully authenticated. If that is the case, then there must be an object
 * named "principal" stored in the HTTP session. - static content (css,
 * javascript, etc.) is not protected - the login page, which displays the login
 * form, is not protected - the authentication servlet, which processes data
 * entered in the login form, is not protected either
 *
 * These rules are enforced in the method. Note that there is no actual password
 * verification. Any password will be accepted in this illustrative scenario.
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch) Edited by Raphaël Racine
 */
public class SecurityFilter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        /*
         * If the target URL is static content or if it is the authentication servlet, then we grant access event
         * if the user has not been authenticated.
         */
        if ("".equals(path) || "/".equals(path) || "/index.html".equals(path) || "index.jsp".equals(path)) {
            request.getRequestDispatcher("/pages/welcome").forward(request, response);
        }

        /*
         * Let's apply a white list access policy. By default, we will authorize access to the target URI on
         * if the user has been authenticated.
         */
        boolean isTargetUrlProtected = true;

        /*
         * If the target URL is static content or if it is the authentication servlet, then we grant access event
         * if the user has not been authenticated.
         */
        if (path.startsWith("/static/")) {
            isTargetUrlProtected = false;
            
            // Authorize access to API Rest
        } else if (path.startsWith("/api")) {
            isTargetUrlProtected = false;
        } else if (path.startsWith("/demoWidgets")) {
            isTargetUrlProtected = false;
        } else if ("/generate".equals(path)) {
            isTargetUrlProtected = false;
        } else if ("/auth".equals(path)) {
            isTargetUrlProtected = false;
        } else if ("/pages/welcome".equals(path)) {
            isTargetUrlProtected = false;
        } else if ("/pages/account".equals(path) && request.getParameter("edit") != null && request.getParameter("edit").equals("false")) {
            isTargetUrlProtected = false;
        } else {
            /*
             * Let's imagine that the user has sent a request to /MVCDemo/pages/beers before logging into the
             * application. In that case, we want to route the user to the login page. If he provides valid
             * credentials, then we then want to redirect the user to /MVCDemo/pages/beers. In order to do that,
             * we need to save the target URL
             */
            request.setAttribute("targetUrl", path);

        }

        /*
         * If the user has been authenticated before, then the AuthenticationServlet has placed
         * an object (in this case a String) in the HTTP session. We can retrieve it.
         */
        Account connectedAccount = (Account) httpRequest.getSession().getAttribute("principal");
        if (connectedAccount == null && isTargetUrlProtected) {
            /*
             * The user has not been authenticated and tries to access a protected resource,
             * we display the login page (and interrupt the request processing pipeline).
             */
            request.getRequestDispatcher("/pages/welcome").forward(request, response);

        } else {
            /*
             * We authorize the access, so we can tell the request processing pipeline to
             * continue its work.
             */
            chain.doFilter(request, response);
            /*
             * Here, we could inspect and manipulate the response and its way back to the
             * client. In this case, we don't have anything to do.
             */
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
