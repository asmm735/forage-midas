package com.jpmc.midascore.foundation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Incentive {
    
    @JsonProperty("amount")
    private float amount;
    
    public Incentive() {
    }
    
    public Incentive(float amount) {
        this.amount = amount;
    }
    
    public float getAmount() {
        return amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
}
