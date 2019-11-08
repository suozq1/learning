package com.suo.javacode.pattern.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.suo.javacode.nio.Consumer;

class Book {
    private String bookName;

    public Book(String name) {
        this.bookName = name;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }
}
class BookShelfIterator implements Iterator<Book>{
    
	private int index=0;
	
	private BookShelf bookShelf;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf=bookShelf;
	}
		
	@Override
	public boolean hasNext() {
		return index < bookShelf.getSize();
	}

	@Override
	public Book next() {
		return bookShelf.getBookAt(index++);
	}
	
}                                 
public class BookShelf implements MyIteratable<Book> {
    private List<Book> bookList=new ArrayList<>();  
    
    public Book getBookAt(int i) {
    	return bookList.get(i);
    }
    
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
    
    public int getSize() {
    	return bookList.size();
    }
    
    public BookShelf(Book ...books) {
    	bookList=Arrays.asList(books);
	}
    
    public static void main(String[] args) {
    	Consumer c = new Consumer();
		BookShelf bookShelf = new BookShelf(new Book("ºìÂ¥ÃÎ"),new Book("Î÷ÓÎ¼Ç"));
		Iterator<Book> bookIterator = bookShelf.iterator();
		while(bookIterator.hasNext()) {
			System.out.println(bookIterator.next().getBookName());
		}
	}
}

