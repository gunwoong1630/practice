package org.example.validation

import com.fasterxml.jackson.databind.ObjectMapper
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test

@WebMvcTest(HttpController::class)
class HttpControllerSliceTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockitoBean
    lateinit var reposiory: MemoryRepository

    @Autowired
    lateinit var om: ObjectMapper

    @Test
    fun `모든 값 정상, post 요청 , 200 OK`() {
        val req = SaveRequest(
            sf1 = "test1",
            sf2 = "test2",
            sf3 = "test3",
            inf = 10,
            df = 1.0,
            bf = true
        )

        val json: String = om.writeValueAsString(req)
        mockMvc.perform(
            post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isOk)
            .andDo {
                print()
            }

        verify(reposiory, times(1)).save(req.toEntity())

    }

    @Test
    fun `inf 제외, post 요청, 400 BAD REQUEST`() {
        val json = om.writeValueAsString(mapOf(
            "stringField1" to "String1",
            "stringField2" to "String2",
            "stringField3" to "String3",
            "doubleField" to 1.0,
            "booleanField" to false
        ))

        mockMvc.perform(
            post("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isBadRequest)
            .andDo {
                print()
            }
        )


    }
}