package edu.estu.ovs;

import edu.estu.ovs.api.controllers.AdminController;
import edu.estu.ovs.service.abstracts.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(AdminController.class)
class AdminControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService service;

    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {

        /*mockMvc.perform(post("/admin/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome Stranger!")));
        verify(welcomeService).getWelcomeMessage("Stranger");*/
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        /*when(service.getWelcomeMessage("John")).thenReturn("Welcome John!");*/
        /*mockMvc.perform(get("/welcome?name=John"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome John!")));
        verify(service).getWelcomeMessage("John");*/
    }
}
