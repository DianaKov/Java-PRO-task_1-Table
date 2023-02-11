<%@ page import="com.example.servlet_example.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet">
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
                <th>#</th>
                <th>Город</th>
                <th>Менеджер</th>
                <th>Марка, модель</th>
                <th>Год выпуска</th>
                <th>Обьем, л</th>
                <th>Коробка передач</th>
                <th>Привод</th>
                <th>Руль</th>
                <th>Цвет</th>
                <th>Цена, грн</th>
                <th>Фамилия И. О.</th>
                <th>Телефон</th>
                <th>Email</th>
                <th>Статус оплаты</th>
            </tr>
        </thead>
        <tbody>
<%--        We can use two variants--%>

<%--            Varian 1 (calling method inside servlet and return String)--%>
<%--            <%=request.getAttribute("customers")%>--%>

<%--            Varian 2 (all manupulation in JSP side)--%>
            <%
                List<Customer> customers = (List<Customer>) request.getAttribute("customersList");
                for (Customer customer : customers) {
//                  For printing in response we must use out object not PrintWriter
                    out.print("<tr><td class=number>" + customer.getNumber() + "</td><td>" +
                            customer.getCity() + "</td><td>" + customer.getManager() + "</td><td>" + customer.getModel() +
                            "</td><td>" + customer.getYear() + "</td><td>" + customer.getVolume() + "</td><td>" +
                            customer.getTransmission() + "</td><td>" + customer.getDriveUnit() + "</td><td>" + customer.getSteeringWheel() +
                            "</td><td>" + customer.getColor() + "</td><td>" + customer.getPrice() + "</td><td>" +
                            customer.getFullName() + "</td><td>" + customer.getTelephone() + "</td><td>" + customer.getEmail() +
                            "</td><td>" + customer.getPaymentState() + "</td></tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>
