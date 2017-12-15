package spring.cloud.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {

	@Autowired
	TestService helloService;

	@RequestMapping("/testConnect")
	public String testConnect() {
		return helloService.testConnect();
	}

	@RequestMapping("/testChangeConfig")
	public String testChangeConfig() {
		return helloService.testChangeConfig();
	}

}