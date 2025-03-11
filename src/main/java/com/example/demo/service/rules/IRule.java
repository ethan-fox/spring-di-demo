package com.example.demo.service.rules;

import com.example.demo.model.RuleInput;
import com.example.demo.model.RuleResult;

public interface IRule {
    public Boolean applies(RuleInput ruleInput);

    public RuleResult execute(RuleInput ruleInput);

}
