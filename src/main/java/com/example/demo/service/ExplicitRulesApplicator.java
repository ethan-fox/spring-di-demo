package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

import lombok.extern.slf4j.Slf4j;

/**
 * Flavor of `RulesApplicator` where the IPrioritizedRules are specified as explicit
 *  conditionals instead of dynamically injected with Spring DI.
 */
@Slf4j
@Component
public class ExplicitRulesApplicator {

    public List<RuleResult> applyRules(RuleInput ruleInput) {
        log.info("Evaluating RuleInput ...");
        
        if (ruleInput.y() % 2 == 0) {
            return List.of(RuleResult.builder()
                .data("An even value! ".concat(String.valueOf(ruleInput.y())))
                .executedRuleName("ExplicitRulesApplicator")
                .build());
        }

        return List.of(RuleResult.builder()
            .data(ruleInput.toString())
            .executedRuleName("ExplicitRulesApplicator")
            .build());
    }
}
