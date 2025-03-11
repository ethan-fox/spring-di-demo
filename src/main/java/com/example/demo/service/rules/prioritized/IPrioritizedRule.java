package com.example.demo.service.rules.prioritized;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

// Different from `IRule` b/c I don't want Spring DI to be confused.
public interface IPrioritizedRule {
    
    public Boolean applies(RuleInput ruleInput);

    public RuleResult execute(RuleInput ruleInput);

    public Integer priority();
}
