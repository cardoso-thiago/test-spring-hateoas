package br.com.cardoso.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/test")
    public String getTest(){return "";}

    @GetMapping("/test/{id}")
    public String getTestId(@PathVariable String id){return "";}

    @GetMapping("/test/query")
    public String getTestQueryParam(@RequestParam String param){return "";}

    @PostMapping("/test")
    public String postTest(@RequestBody String body){return "";}

    @PostMapping("/test/{id}")
    public String postTestId(@RequestBody String body, @PathVariable String id){return "";}

    @PostMapping("/test/query")
    public String postTestQueryParam(@RequestBody String body, @RequestParam String param){return "";}
}
