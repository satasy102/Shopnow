package com.shopnow.controller.home;

import com.shopnow.model.User;
import com.shopnow.model.WebInfo;
import com.shopnow.service.LineOfBusinessService;
import com.shopnow.service.ProvinceService;
import com.shopnow.service.WebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.net.URISyntaxException;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    WebInfoService webInfoService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    LineOfBusinessService lineOfBusinessService;

    @GetMapping
    public ModelAndView index() throws URISyntaxException {
        System.out.println("duong dan file: " + new File(HomeController.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getPath());
        WebInfo webInfo=webInfoService.findById(1L);
        ModelAndView modelAndView = new ModelAndView("fe/home/index","webInfo", webInfo);
        modelAndView.addObject("provinces", provinceService.findAll());
        modelAndView.addObject("user", new User());
        modelAndView.addObject("lineOfBusinesses", lineOfBusinessService.findAll());
        return modelAndView;
    }

}
