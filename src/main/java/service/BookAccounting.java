package service;

import dao.UserRepository;
import model.Book;
import model.User;

public class BookAccounting {
    private UserRepository userRepository;

    public BookAccounting(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void loanBook(User user, Book book) {

    }
}
