package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EventPacket;
import com.example.demo.model.StorageResult;
import com.example.demo.service.EventStorageService;
import com.example.demo.service.MyService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("demo-rest")
class DemoController {

    private final MyService myService;
    private final EventStorageService eventStorageService;

    public DemoController(final MyService myService, final EventStorageService eventStorageService) {
        this.myService = myService;
        this.eventStorageService = eventStorageService;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return myService.f();
    }

    @PostMapping("/publish-event")
    public List<StorageResult> postMethodName(@RequestBody EventPacket eventPacket) {
        return this.eventStorageService.persistEvent(eventPacket);
    }
    
}