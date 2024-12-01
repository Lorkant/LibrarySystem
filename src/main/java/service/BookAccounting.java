package service;

import dao.BookRepository;
import dao.OrderRepository;
import dao.UserRepository;
import model.Book;
import model.Order;
import model.User;

public class BookAccounting {
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private BookRepository bookRepository;

    public BookAccounting(UserRepository userRepository, OrderRepository orderRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
    }

    public void loanBook(Integer userId, Integer bookId) {
        Order order = new Order(userId, bookId, "01.12.2024");
        orderRepository.addOrder(order);
    }

    public void getUserLoans(Integer userId) {
        User user = userRepository.getUser(userId);
        Order order = orderRepository.getOrderByUserId(userId);
        Integer bookId = order.getBookId();
        Book book = bookRepository.getBook(bookId);
        System.out.printf("%s %s взял в долг книгу %s %s" , user.getName(), user.getLastname(), book.getName(), order.getDate());
    }
}
