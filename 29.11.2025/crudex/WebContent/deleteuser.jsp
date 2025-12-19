<%
int id = Integer.parseInt(request.getParameter("id"));
User u = new User();
u.setId(id);
UserDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>
