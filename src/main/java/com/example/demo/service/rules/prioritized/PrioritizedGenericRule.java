package com.example.demo.service.rules.prioritized;

import org.springframework.stereotype.Component;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrioritizedGenericRule implements IPrioritizedRule {

        // This rule will apply in all circumstances.
    @Override
    public Boolean applies(RuleInput ruleInput) {
        return true;
    }

    @Override
    public RuleResult execute(RuleInput ruleInput) {
        log.info("Executing PrioritizedGenericRule ...");
        return RuleResult.builder()
            .executedRuleName(this.getClass().getSimpleName())
            .data(ruleInput.toString())
            .build();
    } 
    
    public Integer priority() {
        return Integer.MAX_VALUE;
    }
}
