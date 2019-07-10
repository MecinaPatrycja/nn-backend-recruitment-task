package pl.patrycjamecina.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.patrycjamecina.model.GithubUser;
import pl.patrycjamecina.service.impl.GithubUserServiceImpl;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
@RunWith(MockitoJUnitRunner.class)
public class UserApiUnitTest {
    @InjectMocks
    private GithubUserController githubUserController;
    @Mock
    private GithubUserServiceImpl githubUserService;
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(githubUserController).build();
    }

    @Test
    public void getUser() throws Exception {
        GithubUser testGithubUser = new GithubUser();
        testGithubUser.setAvatarUrl("www.test.avatar.com");
        testGithubUser.setCreatedAt(null);
        testGithubUser.setId(1L);
        testGithubUser.setLogin("superhero");
        testGithubUser.setName("Kate");
        testGithubUser.setType("User");
        given(githubUserService.getGithubUserInfo()).willReturn(testGithubUser);
        mockMvc.perform(MockMvcRequestBuilders.get("/user/info")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(testGithubUser)))
                .andDo(print())
                .andExpect(jsonPath("name").value("Kate"))
                .andExpect(jsonPath("login").value("superhero"))
                .andExpect(jsonPath("type").value("User"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String toJson(GithubUser githubUserResponseEntity) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(githubUserResponseEntity);
    }
}