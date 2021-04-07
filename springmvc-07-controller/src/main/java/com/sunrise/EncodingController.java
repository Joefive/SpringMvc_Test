package com.sunrise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 1.Get方法使用Servlet过滤器解决乱码，Post方法不行！
 * 2.Post方法可以使用SpringMvc过滤器进行解决
 *
 */
@Controller
public class EncodingController {

    @PostMapping("/e/t1")
    public String encodingTest(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }
}
