// package com.example.demo.servlet;

// import jakarta.servlet.http.*;
// import java.io.IOException;

// public class SimpleStatusServlet extends HttpServlet {

//     // ✅ MUST BE PUBLIC
//     @Override
//     public void doGet(HttpServletRequest req,
//                       HttpServletResponse resp) throws IOException {
//         resp.getWriter().write("OK");
//     }
// }
package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.getWriter().write("OK");
    }
}
