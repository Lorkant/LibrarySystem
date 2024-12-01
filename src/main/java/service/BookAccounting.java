package service;

import dao.BookRepository;
import dao.OrderRepository;
import dao.UserRepository;
import model.Book;
import model.Order;
import model.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String newdate = sdf.format(new Date());
        Order order = new Order(userId, bookId,  newdate);
        orderRepository.addOrder(order);
        bookRepository.getBook(bookId).setAvailable(false);
    }

    public void returnBook(Integer userId, Integer bookId){
        bookRepository.getBook(bookId).setAvailable(true);
        List<Order> orders = orderRepository.getOrdersByUserId(userId);
        for (Order order : orders) {
            if (bookId == order.getBookId()){
                bookRepository.getBook(bookId).setAvailable(true);
            }
        }
    }

    public void getUserLoans(Integer userId) {
        User user = userRepository.getUser(userId);
        List<Order> orders = orderRepository.getOrdersByUserId(userId);
        for (Order order : orders){
            Integer bookId = order.getBookId();
            Book book = bookRepository.getBook(bookId);
            System.out.printf("%s %s взял в долг книгу %s %s. %n", user.getName(), user.getLastname(), book.getName(), order.getDate());
        }
    }

    public List<Book> availableBooks(){
        Collection<Book> books = bookRepository.returnAllBooks();
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books){
            if (book.isAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public void printAvailableBooks(){
        List<Book> books = availableBooks();
        if (books.isEmpty()){
            System.out.println("Нет доступных книг");
        } else {
            System.out.println("Список доступных книг:");
            for (Book book : books) {
                System.out.println(book.getName());
            }
        }
    }
}
