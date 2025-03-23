package com.question.services.QuestionResult;

import com.question.entities.QuestionResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "http://localhost:9093", value = "QuestionResult-Client")
//@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionResultClinet {

    @GetMapping("/questionresult/getAllResultOfQuestion/{questionid}")
    List<QuestionResult> getAllResultOfQuestion(@PathVariable int questionid);

}
