package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //html에 나오는 바디태그가 아니라 http통신 바디영역에 내용을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);
        return hello;   //리턴값이 문자가 아닌 객체라면 json방식으로 반환한다.
    }


    static class Hello{
        private String name;

        //ctrl+N or ctrl+enter
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
