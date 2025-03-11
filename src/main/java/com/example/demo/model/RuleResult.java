package com.example.demo.model;

import lombok.Builder;

@Builder
public record RuleResult(
    String executedRuleName,
    String data
) {

}
