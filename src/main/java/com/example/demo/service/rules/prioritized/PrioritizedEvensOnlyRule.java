package com.example.demo.service.rules.prioritized;

import org.springframework.stereotype.Component;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrioritizedEvensOnlyRule implements IPrioritizedRule  {


        // This rule only applies if `y` is even
    @Override
    public Boolean applies(RuleInput ruleInput) {
        return ruleInput.y() % 2 == 0;
    }

    @Override
    public RuleResult execute(RuleInput ruleInput) {
        log.info("Executing EvensOnlyRule ...");
        return RuleResult.builder()
            .executedRuleName(this.getClass().getSimpleName())
            .data("An even value! ".concat(String.valueOf(ruleInput.y())))
            .build();
    }
    
    
    public Integer priority() {
        return Integer.MIN_VALUE;
    }
}
