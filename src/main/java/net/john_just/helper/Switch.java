package net.john_just.helper;

import net.john_just.helper.enums.PoleCount;
import net.john_just.helper.enums.RatedCurrent;
import net.john_just.helper.enums.StockStatus;

public class Switch extends Component {
    protected ModelName modelName;
    protected RatedCurrent ratedCurrent;
    protected PoleCount poleCount;

    public Switch(ComponentName name, Manufacturer manufacturer, ModelName modelName,
                  double price, int quantity , StockStatus stockStatus, RatedCurrent ratedCurrent,
                  PoleCount poleCount) {
        super(name, manufacturer, price, quantity, stockStatus);
        this.modelName = modelName;
        this.ratedCurrent = ratedCurrent;
        this.poleCount = poleCount;
    }

    @Override
    public String getInfo() {
        return name + " " + poleCount.toString() + " " + manufacturer + " " + modelName + " " + ratedCurrent.toString();
    }
}
