package main;

import dao.BookRepository;
import dao.OrderRepository;
import dao.UserRepository;
import model.Book;
import model.User;
import service.BookAccounting;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        BookRepository bookRepository = new BookRepository();
        OrderRepository orderRepository = new OrderRepository();
        BookAccounting accounting = new BookAccounting(userRepository, orderRepository, bookRepository);
        User ivan = new User(1, "Иван", "Вертилецкий" , "19.11.1998", 123456, "client");
        userRepository.saveUser(ivan);
        Book dune = new Book(1, "Фантастика", "Дюна");
        Book harryPotter1 = new Book(2, "Фантастика", "Гарри Поттер и Тайная комната");
        bookRepository.addBook(dune);
        bookRepository.addBook(harryPotter1);
        accounting.loanBook(ivan.getId(), dune.getId());
        accounting.loanBook(ivan.getId(), harryPotter1.getId());
        accounting.getUserLoans(ivan.getId());
        accounting.returnBook(ivan.getId(), dune.getId());
    }
}
