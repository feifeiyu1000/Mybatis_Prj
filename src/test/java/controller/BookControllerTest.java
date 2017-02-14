package controller;

import com.springHello.bean.Book;
import com.springHello.controller.BookController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by mar1 on 2/14/17.
 */
public class BookControllerTest {

    @Mock
    private BookService bookService;


    @InjectMocks
    private BookController bookController;


    private MockMvc mockMvc;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testMockCreation(){
        assertNotNull(bookService);
        assertNotNull(bookController);
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
