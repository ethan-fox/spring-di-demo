package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;
import com.example.demo.service.rules.IRule;
import com.example.demo.service.rules.prioritized.IPrioritizedRule;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RulesApplicator {
    
    private final List<IRule> rules;
    private final List<IPrioritizedRule> prioritizedRules;
    private final ExplicitRulesApplicator explicitRulesApplicator;
    
    public RulesApplicator(List<IRule> rules, List<IPrioritizedRule> prioritizedRules, final ExplicitRulesApplicator explicitRulesApplicator) {
        this.rules = rules;
        this.prioritizedRules = prioritizedRules;
        this.explicitRulesApplicator = explicitRulesApplicator;
    }

    // @Timed()
    public List<RuleResult> runRules(RuleInput ruleInput, Boolean prioritize, Boolean explicit) {
        log.info("Evaluating rules ...");
        return prioritize 
            ? explicit
                ? explicitRulesApplicator.applyRules(ruleInput)
                : runPrioritized(ruleInput)
                .map(List::of)
                .orElse(Collections.emptyList())
            : runNonPrioritizedRules(ruleInput);
    }

    private Optional<RuleResult> runPrioritized(RuleInput ruleInput) {
        return prioritizedRules.stream()
            .filter(rule -> rule.applies(ruleInput))
            .sorted(Comparator.comparing(IPrioritizedRule::priority))
            .findFirst()
            .map(rule -> rule.execute(ruleInput));
    }

    private List<RuleResult> runNonPrioritizedRules(RuleInput ruleInput) {
        return rules.stream()
            .filter(rule -> rule.applies(ruleInput))
            .map(rule -> rule.execute(ruleInput))
            .toList();
    }
}
