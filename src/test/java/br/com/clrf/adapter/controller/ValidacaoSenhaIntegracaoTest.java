package br.com.clrf.adapter.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ValidacaoSenhaIntegracaoTest {

    private static final String ENDPOINT = "/senhas/validacoes";
    private static final MediaType JSON = MediaType.APPLICATION_JSON;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void retornaSenhaValida() throws Exception {
        String corpo = "{\"senha\":\"AbTp9!fok\"}";

        mockMvc.perform(post(ENDPOINT)
                        .contentType(JSON)
                        .accept(JSON)
                .content(corpo))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(JSON))
                .andExpect(jsonPath("$.valido").value(true));
    }

}
