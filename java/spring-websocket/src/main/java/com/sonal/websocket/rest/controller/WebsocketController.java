package com.sonal.websocket.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonal.websocket.rest.controller.vo.WebRequestVO;
import com.sonal.websocket.rest.controller.vo.WebResponseVO;
import com.sonal.websocket.service.IHealthCheckService;
import com.sonal.websocket.service.IStudentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/websocket")
public class WebsocketController {

    static final Logger logger = LoggerFactory.getLogger(WebsocketController.class);

    @Autowired
    private IHealthCheckService healthCheckService;
    
    @Autowired
    private IStudentService studentService;
    
    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping(value = "healthCheck", produces = "application/json")
    public Mono<WebResponseVO> healthCheck() {
        
        return healthCheckService.inspectHealth();
    }    
   
    @PostMapping(value = "findStudent", consumes = "application/json",produces = "application/json")
    public Mono<WebResponseVO> findStudent(@RequestBody WebRequestVO webRequestVO) {
        
        return studentService.findStudent(webRequestVO.getUserName());
    }
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public WebResponseVO greeting(WebRequestVO webRequestVO) throws Exception {
        Thread.sleep(1000); // simulated delay
        WebResponseVO webResponseVO = new WebResponseVO();
        webResponseVO.setMessage("Hello, " + webRequestVO.getUserName() + "!");
	return webResponseVO;
    }
    
    @Scheduled(fixedDelay=3000)
    public void serverPush() throws Exception {
	logger.info("Server Push");
        WebResponseVO webResponseVO = new WebResponseVO();
        webResponseVO.setMessage("ServerPush");
        this.template.convertAndSend("/topic/greetings", webResponseVO);
    }


}
