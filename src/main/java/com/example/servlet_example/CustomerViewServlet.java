package com.example.servlet_example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerViewServlet extends HttpServlet {


    private List<Customer> customers
            = Arrays.asList(new Customer(1, "Харьков", "Кирил", "Honda Vezel", 2015, 1.5, "робот", "4WD", "правый", "серый", 825000, "Божко А. П.", 975398781, "@jkj", "оплачено"),
                            new Customer(2, "Харьков", "Максим", "Lexus ES250", 2019, 2.0, "АКПП", "передний", "левый", "черный", 1815000, "Тутик К. А.", 974561298, "@kfnfld", "не оплачено"),
                            new Customer(3, "Харьков", "Максим", "Lexus RX300", 2019, 2.0, "АКПП", "4WD", "левый", "синий", 2277000, "Попович А. А.", 974854578, "@dfbd", "не оплачено"),
                            new Customer(4, "Харьков", "Максим", "Mazda Axela", 2017, 1.5, "АКПП", "4WD", "правый", "черный", 540000, "Романов Е. С.", 975245781, "@jdrhfm", "оплачено"),
                            new Customer(5, "Харьков", "Лена", "Mazda CX-3", 2017, 2.0, "АКППт", "передний", "правый", "черный", 765000, "Соринов О. О.", 97239481, "@jkvdfvj", "оплачено"),
                            new Customer(6, "Киев", "Алина", "Mitsubishi Pajero", 2019, 3.0, "АКПП", "4WD", "левый", "синий", 1500000, "Иванец В. А.", 955398781, "@jkbnhgdj", "не оплачено"),
                            new Customer(7, "Киев", "Алина", "Nissan Juke", 2017, 1.5, "вариатор", "передний", "правый", "черный", 100000, "Петрова У. И.", 954978781, "@jcdvgfbhkj", " неоплачено"),
                            new Customer(8, "Киев", "Александр", "Nissan Note", 2017, 1.2, "вариатор", "передний", "правый", "черный", 515000, "Миленко И. И.", 665398781, "@jkcdsvj", "оплачено"),
                            new Customer(9, "Киев", "Вячеслав", "Nissan Skyline", 2017, 2.0, "АКПП", "задний", "правый", "желтый", 950000, "Северов П. Р.", 956398781, "@jkbnnmj", "оплачено"),
                            new Customer(10, "Киев", "Иван", "Subaru Impreza", 2019, 2.0, "вариатор", "4WD", "правый", "белый", 845000, "Ким М. Т.", 974157881, "@jkj", " не оплачено"),
                            new Customer(11, "Одесса", "Карина", "Subaru Forester", 2021, 1.8, "вариатор", "4WD", "левый", "белый", 1595000, "Максименко А. В.", 97136581, "@jkqwwwwwj", "оплачено"),
                            new Customer(12, "Одесса", "Георгий", "Subaru  XV", 2018, 1.6, "вариатор", "4WD", "правый", "красный", 810000, "Чопорнова К. М.", 975399451, "@jkfdytuij", "оплачено"),
                            new Customer(13, "Одесса", "Диана", "Suzuki Jimmy", 2021, 0.7, "механика", "4WD", "правый", "белый", 1050000, "Пак Б. О.", 971198781, "@opopipijkj", "оплачено"),
                            new Customer(14, "Одесса", "Диана", "Toyota Prius", 2018, 1.8, "вариатор", "передний", "правый", "серый", 847500, "Потопаво К. А.", 972424781, "@jrtryrkj", "не оплачено"),
                            new Customer(15, "Одесса", "Диана", "Toyota Land Cruiser", 2021, 3.3, "АКПП", "4WD", "левый", "красный", 7000000, "Голубев Р. О.", 977395581, "@jaaqaaawj", "оплачено")
                            );



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customersList", customers);
        request.setAttribute("customers", getCustomerTable());
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
    }

    public String getCustomerTable() {
        StringBuilder sb = new StringBuilder();
            for (Customer customer : customers) {
                sb.append("<tr><td class=number>")
                        .append(customer.getNumber())
                        .append("</td><td>")
                        .append(customer.getCity())
                        .append("</td><td>")
                        .append(customer.getManager())
                        .append("</td></tr>")
                        .append(customer.getModel())
                        .append("</td><td>")
                        .append(customer.getYear())
                        .append("</td></tr>")
                         .append(customer.getVolume())
                        .append("</td><td>")
                        .append(customer.getTransmission())
                        .append("</td></tr>")
                        .append(customer.getDriveUnit())
                        .append("</td><td>")
                        .append(customer.getSteeringWheel())
                        .append("</td></tr>")
                        .append(customer.getColor())
                        .append("</td><td>")
                        .append(customer.getPrice())
                        .append("</td></tr>")
                        .append(customer.getFullName())
                        .append("</td><td>")
                        .append(customer.getTelephone())
                        .append("</td></tr>")
                        .append(customer.getEmail())
                        .append("</td><td>")
                        .append(customer.getPaymentState())
                        .append("</td></tr>");
            }
        return sb.toString();

    }

}
