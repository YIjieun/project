<%
//가상경로/ event/실제는 존재X 있는것처럼 경로를 지정(보안때문에)
 /*  response.sendRedirect(request.getContextPath()+"/board/eventList.do"); */
response.sendRedirect(request.getContextPath()+"/board/Main.do");
%>