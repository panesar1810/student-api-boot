package code.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootResponse {

	@GetMapping
	private String index() {
		return "index.html";
	}
	
}
