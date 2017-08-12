package com.lance.demo.spring.web;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Controller
@RequestMapping("/uri")
public class URIController {
    // /uri/components
    @GetMapping("/components")
    @ResponseBody
    public String uriComponents() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://www.lance.com:8080/uri/{dynamic}/{path}/test?name=lance&age=10").build();
        URI uri = uriComponents.expand("42", "21").encode().toUri();
        return uri.toString();
    }

    // /uri/servlet
    @GetMapping("/servlet")
    @ResponseBody
    public String servletUri(HttpServletRequest httpRequest) {
        URI uri = ServletUriComponentsBuilder.fromRequest(httpRequest).replaceQueryParam("uri","url").replacePath("uri").build().encode().toUri();
        return uri.toString();
    }
}
