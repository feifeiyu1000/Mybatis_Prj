import com.springHello.bean.Book;
import com.springHello.mapper.BookMapper;
import com.springHello.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 1/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceTest {

    @Mock
    private BookMapper bookMapper;

    @InjectMocks
    private BookService bookService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllBooks(){
        Collection<Book> books = bookService.findAllBooksV2();
        assertEquals(books.size(),2);
        books.stream().forEach(System.out::println);
    }

    @Test
    public void testFindBookById(){
        Date myDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2017);
        cal.set(Calendar.DATE,26);
        cal.set(Calendar.MONTH,01);
        cal.set(Calendar.HOUR,01);
        cal.set(Calendar.MINUTE,02);
        cal.set(Calendar.SECOND,07);
        myDate = cal.getTime();
        Book book = new Book();
        book.setId(1);
        book.setName("JavaEE");
        book.setNbrPage(500);
        book.setCreationDate(myDate);
        when(bookService.findBookById(1L)).thenReturn(book);
    }

}
