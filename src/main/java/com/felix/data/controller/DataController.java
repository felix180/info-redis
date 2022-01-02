package com.felix.data.controller;

import com.felix.data.domain.DataRequest;
import com.felix.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController("/")
public class DataController {



  @Autowired private DataService dataService;

  @PostMapping("/data")
  public @ResponseBody
  Double processData(@RequestBody DataRequest dataRequest) {
    return dataService.processData(dataRequest);
  }


  @RequestMapping(value = "/")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }
}
