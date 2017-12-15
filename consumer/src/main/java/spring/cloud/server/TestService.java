package spring.cloud.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@RefreshScope
public class TestService {

	@Value("${provider.application.service.id}")
	private String provider;
	
	@Value("${server.port}")
	private int port;
	@Value("${config.test}")
	private String testStr;


	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "connetError")
	public String testConnect() {
		System.out.println("当前消费端："+port);
		return restTemplate.getForObject("http://" + provider + "/getPort",
				String.class);
	}

	public String connetError() {
		return "当前访问的连接无法访问！";
	}
	
	public String testChangeConfig(){
		return testStr;
	}
}