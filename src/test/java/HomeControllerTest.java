import com.springHello.bean.Book;
import com.springHello.controller.HomeController;
import com.springHello.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/**
 * Created by mar1 on 2/7/17.
 */
public class HomeControllerTest {

    // config mock without annotation
    /*
    private BookService bookService;
    private BookServiceImpl bookServiceImpl;

    @Before
    public void setupMock(){
        bookServiceImpl = new BookServiceImpl();
        bookService = mock(BookService.class);
    }
    */

    // config mock with annotation

    @Mock
    private BookService bookService;

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testMockCreation(){
        assertNotNull(bookService);
        assertNotNull(homeController);
    }

    @Test
    public void testBooksUrl_shouldReturnBookListView() throws Exception {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book());
        bookList.add(new Book());

        when(bookService.findAllBooks()).thenReturn((List) bookList);
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(view().name("booksList"))
                .andExpect(model().attribute("books",bookList));
    }

}
