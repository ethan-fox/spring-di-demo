package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EventPacket;
import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;
import com.example.demo.model.StorageResult;
import com.example.demo.service.EventStorageService;
import com.example.demo.service.MyService;
import com.example.demo.service.RulesApplicator;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("demo-rest")
class DemoController {

    private final MyService myService;
    private final EventStorageService eventStorageService;
    private final RulesApplicator rulesApplicator;

    public DemoController(final MyService myService, final EventStorageService eventStorageService, final RulesApplicator rulesApplicator) {
        this.myService = myService;
        this.eventStorageService = eventStorageService;
        this.rulesApplicator = rulesApplicator;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return myService.f();
    }

    @PostMapping("/publish-event")
    public List<StorageResult> publishEvent(@RequestBody EventPacket eventPacket) {
        return this.eventStorageService.persistEvent(eventPacket);
    }

    @PostMapping("/apply-rules")
    public List<RuleResult> applyRules(@RequestBody RuleInput ruleInput, @RequestParam(defaultValue = "false") Boolean prioritize) {
        return this.rulesApplicator.runRules(ruleInput, prioritize);
    }
    
    
}