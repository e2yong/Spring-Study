package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// HTTP Request 정보 출력(StartLine, Headers, HeaderUtils, etc)
// http://localhost:8080/request-header?username=hello
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("=== HTTP Request 메시지 정보 - start ===");
        System.out.println();

        // Start Line 정보
        printStartLine(request);
        // Header 모든 정보
        printHeaders(request);
        // Header 편의 정보
        printHeaderUtils(request);
        // 기타 정보
        printEtc(request);

        System.out.println("=== HTTP Request 메시지 정보 - end ===");
        System.out.println();
    }

    // Start Line
    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- Start Line 정보 - start ---");

        // http://localhost:8080/request-header?username=hello
        // HTTP 메소드(GET)
        System.out.println("request.getMethod() = " + request.getMethod());
        // 프로토콜(HTTP/1.1)
        System.out.println("request.getProtocol() = " + request.getProtocol());
        // 스키마(http)
        System.out.println("request.getScheme() = " + request.getScheme());
        // URL(http://localhost:8080/request-header)
        System.out.println("request.getRequestURL() = " + request.getRequestURL()); // /request-header
        // URI(/request-header)
        System.out.println("request.getRequestURI() = " + request.getRequestURI()); //username=hi
        // 쿼리 스트링(username=hello)
        System.out.println("request.getQueryString() = " + request.getQueryString());
        // HTTPS 사용 유무(false)
        System.out.println("request.isSecure() = " + request.isSecure()); //https 사용

        System.out.println("--- Start Line - end ---");
        System.out.println();
    }

    // Headers
    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers 모든 정보 - start ---");

//        // 옛날 방식
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + ": " + request.getHeader(headerName));
//        }

        // 요즘 방식
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName ->
                        System.out.println(headerName + ": " + request.getHeader(headerName)));

        System.out.println("--- Headers 모든 정보 - end ---");
        System.out.println();
    }

    // Header Utils
    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 정보 - start ---");

        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale ->
                        System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("--- Header 편의 정보 - end ---");
        System.out.println();
    }

    // etc
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 정보 - start ---");

        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println();

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("--- 기타 정보 - end ---");
        System.out.println();
    }
}
