package com.dyz.dev.model;

import org.apache.catalina.LifecycleState;

import java.util.List;

public class SpecChangeFormBean {
    SpecChangeForm specChangeForm;
    List<SpecUserUnit> userUnits;

    public SpecChangeForm getSpecChangeForm() {
        return specChangeForm;
    }

    public void setSpecChangeForm(SpecChangeForm specChangeForm) {
        this.specChangeForm = specChangeForm;
    }

    public List<SpecUserUnit> getUserUnits() {
        return userUnits;
    }

    public void setUserUnits(List<SpecUserUnit> userUnits) {
        this.userUnits = userUnits;
    }
}
