import com.springHello.bean.Book;
import com.springHello.mapper.BookMapper;
import com.springHello.service.BookService;
import com.springHello.service.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by root on 1/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    public void testFindAllBooks(){
        List<Book> books = bookService.findAllBooks();
        assertEquals(books.size(),2);
        books.stream().forEach(System.out::println);
    }

    @Test
    public void testInsertBook(){
        Book book = new Book();
        book.setName("MyBatis");
        book.setNbrPage(200);
        book.setCreationDate(new Date());
        bookService.insertBook(book);
        List<Book> books = bookService.findAllBooks();
        Long count = books.stream()
                .filter((b) -> b.getName().equals("MyBatis"))
                .count();
        assertEquals(Optional.ofNullable(count), Optional.of(1L));
    }

    @Test
    public void testDeleteBook(){
        Book book1 = bookService.findBookByName("MyBatis");
        bookService.deleteBook(book1.getId());
        Book book = bookService.findBookById(book1.getId());
        assertNull(book);
    }

    @Test
    public void testFindBookByName(){
        Book book = bookService.findBookByName("JavaEE");
        assertNotNull(book);
    }


    @Test
    public void testFindBookById(){
        /*
        Date myDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.DATE,25);
        cal.set(Calendar.MONTH,01);
        cal.set(Calendar.HOUR,13);
        cal.set(Calendar.MINUTE,02);
        cal.set(Calendar.SECOND,07);
        myDate = cal.getTime();
        Book book = new Book();
        book.setId(1);
        book.setName("JavaEE");
        book.setNbrPage(500);
        book.setCreationDate(myDate);*/
        Book book1 = bookService.findBookById(1L);
        assertNotNull(book1);
    }

}
