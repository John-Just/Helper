package net.john_just.helper;

import net.john_just.helper.enums.LeakageCurrent;
import net.john_just.helper.enums.PoleCount;
import net.john_just.helper.enums.RatedCurrent;
import net.john_just.helper.enums.StockStatus;

public class RCBO extends Switch{
    private LeakageCurrent leakageCurrent;

    public RCBO(ComponentName name, Manufacturer manufacturer, ModelName modelName,
               double price, int quantity, RatedCurrent ratedCurrent, LeakageCurrent leakageCurrent,
                PoleCount poleCount, StockStatus stockStatus) {
        super(name, manufacturer, modelName, price, quantity, stockStatus, ratedCurrent, poleCount);
        this.leakageCurrent = leakageCurrent;
    }

    @Override
    public String getInfo() {
        return name + " " + poleCount.toString() + " " + manufacturer + " " + modelName + " " + ratedCurrent.toString() + " " + leakageCurrent;
    }
}
