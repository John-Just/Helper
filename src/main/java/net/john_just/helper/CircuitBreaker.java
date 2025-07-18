package net.john_just.helper;

import net.john_just.helper.enums.BreakerType;
import net.john_just.helper.enums.PoleCount;
import net.john_just.helper.enums.RatedCurrent;
import net.john_just.helper.enums.StockStatus;

public class CircuitBreaker extends Switch {
    private BreakerType breakerType;

    public CircuitBreaker(ComponentName name, Manufacturer manufacturer, ModelName modelName,
                          double price, int quantity, StockStatus stockStatus, RatedCurrent ratedCurrent,
                          BreakerType breakerType, PoleCount poleCount) {
        super(name, manufacturer, modelName, price, quantity, stockStatus, ratedCurrent, poleCount);
        this.breakerType = breakerType;
    }

    @Override
    public String getInfo() {
        return name + " " + poleCount.toString() + " " + manufacturer + " " + modelName + " " + breakerType + " " + ratedCurrent.toString();
    }
}
