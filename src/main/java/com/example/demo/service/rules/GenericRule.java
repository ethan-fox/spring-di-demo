package com.example.demo.service.rules;

import org.springframework.stereotype.Component;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GenericRule implements IRule {
    
    // This rule will apply in all circumstances.
    @Override
    public Boolean applies(RuleInput ruleInput) {
        return true;
    }

    @Override
    public RuleResult execute(RuleInput ruleInput) {
        log.info("Executing GenericRule ...");
        return RuleResult.builder()
            .executedRuleName(this.getClass().getSimpleName())
            .data(ruleInput.toString())
            .build();
    } 
}
