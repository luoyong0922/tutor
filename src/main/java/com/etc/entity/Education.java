package com.etc.entity;

public class Education {
    private Long primary;
    private Long middle;
    private Long high;

    public Long getPrimary() {
        return primary;
    }

    public void setPrimary(Long primary) {
        this.primary = primary;
    }

    public Long getMiddle() {
        return middle;
    }

    public void setMiddle(Long middle) {
        this.middle = middle;
    }

    public Long getHigh() {
        return high;
    }

    public void setHigh(Long high) {
        this.high = high;
    }

    public Education() {
    }

    public Education(Long primary, Long middle, Long high) {
        this.primary = primary;
        this.middle = middle;
        this.high = high;
    }


    private Long Chinese;
    private Long math;
    private Long English;
    private Long Physics;
    private Long Chemistry;
    private Long Biology;

    public Long getChinese() {
        return Chinese;
    }

    public void setChinese(Long chinese) {
        Chinese = chinese;
    }

    public Long getMath() {
        return math;
    }

    public void setMath(Long math) {
        this.math = math;
    }

    public Long getEnglish() {
        return English;
    }

    public void setEnglish(Long english) {
        English = english;
    }

    public Long getPhysics() {
        return Physics;
    }

    public void setPhysics(Long physics) {
        Physics = physics;
    }

    public Long getChemistry() {
        return Chemistry;
    }

    public void setChemistry(Long chemistry) {
        Chemistry = chemistry;
    }

    public Long getBiology() {
        return Biology;
    }

    public void setBiology(Long biology) {
        Biology = biology;
    }

    public Education(Long chinese, Long math, Long english, Long physics, Long chemistry, Long biology) {
        Chinese = chinese;
        this.math = math;
        English = english;
        Physics = physics;
        Chemistry = chemistry;
        Biology = biology;
    }

    @Override
    public String toString() {
        return "Education{" +
                "primary=" + primary +
                ", middle=" + middle +
                ", high=" + high +
                ", Chinese=" + Chinese +
                ", math=" + math +
                ", English=" + English +
                ", Physics=" + Physics +
                ", Chemistry=" + Chemistry +
                ", Biology=" + Biology +
                '}';
    }

    public Education(Long primary, Long middle, Long high, Long chinese, Long math, Long english, Long physics, Long chemistry, Long biology) {
        this.primary = primary;
        this.middle = middle;
        this.high = high;
        Chinese = chinese;
        this.math = math;
        English = english;
        Physics = physics;
        Chemistry = chemistry;
        Biology = biology;
    }
}
