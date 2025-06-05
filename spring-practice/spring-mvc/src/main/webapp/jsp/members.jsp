<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> allMember = memberRepository.findAllId();
%>

<html>
  <head>
      <meta charset="UTF-8">
      <title>Title</title>
  </head>
<body>
<a href="/index.html">메인</a>
<table>
    <thread>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thread>
    <tbody>
<%
for (Member member : allMember) {
            out.write("    <tr>");
            out.write("        <td>" + member.getId() + "</td>");
            out.write("        <td>" + member.getUsername() + "</td>");
            out.write("        <td>" + member.getAge() + "</td>");
            out.write("    </tr>");
        }
%>
    </tbody>
</table>
</body>
</html>
