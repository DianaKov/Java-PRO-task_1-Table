<%@ page import="com.example.servlet_example.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            margin-left: auto;
            margin-right: auto;
        }
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
<%--        We can use two variants--%>

<%--            Variant 1 (calling method inside servlet and return String)--%>
<%--            <%=request.getAttribute("customers")%>--%>

<%--            Variant 2 (all manupulation in JSP side)--%>
            <%
                List<Customer> customers = (List<Customer>) request.getAttribute("customersList");
                for (Customer customer : customers) {
//                  For printing in response we must use out object not PrintWriter
                    out.print("<tr><td>" + customer.getName() + "</td><td>"  + customer.getAddress() + "</td></tr>");
                }
            %>


<%--            Variant 3 (using JSTL)--%>
<%--        <c:forEach items="${customersList}" var="customer">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${customer.name}"/></td>--%>
<%--                <td><c:out value="${customer.address}"/>1</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</body>
</html>
