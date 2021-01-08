<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.hongyi.dao.UserDao" %>
<%@ page import="com.hongyi.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    InputStream in = User.class.
            getClassLoader().getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    SqlSession sqlSession = factory.openSession();
    UserDao mapper = sqlSession.getMapper(UserDao.class);
    List<User> all = mapper.findAll();
    System.out.println(all);
    sqlSession.close();
%>
</body>
</html>
