package com.lance.demo.spring.controller;

import com.lance.demo.spring.util.EncryptUtil;
import com.lance.demo.spring.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//@RestController
//@RequestMapping("/pay")
@Slf4j
public class PayController {
    //@Autowired
    private RestTemplate restTemplate;
    private String url = "https://public.baofoo.com/baofoo-fopay/pay/BF0040001.do";

    @PostMapping("/pay")
    public String pay(@RequestBody LoanReq loanReq) throws Exception{
        PayReq payReq = new PayReq.Builder<LoanReq>()
                .memberId("100000276")
                .terminalId("100000990")
                .publicKey(EncryptUtil.loadPublicKey("certificate/bfkey_100000276@@100000990.cer"))
                .content(loanReq)
                .build();
        log.info("req:{}",JsonUtil.getJson(payReq));
        ResponseEntity<PayRsp> payRspResponseEntity = restTemplate.postForEntity(url, payReq, PayRsp.class);
        log.info(payRspResponseEntity.toString());
        return "success";
    }
}
