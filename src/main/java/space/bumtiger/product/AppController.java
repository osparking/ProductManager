package space.bumtiger.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {
	@Autowired
	private ProductService service;
	
	// 처리기 메소드들...

}
