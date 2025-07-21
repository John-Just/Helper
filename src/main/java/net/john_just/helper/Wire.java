package net.john_just.helper;

import net.john_just.helper.enums.CrossSection;
import net.john_just.helper.enums.StockStatus;
import net.john_just.helper.enums.WireColor;

public class Wire extends Component {
    private WireColor color;
    private CrossSection crossSection;

    public Wire(ComponentName name, Manufacturer manufacturer, double price, int quantity,
                StockStatus stockStatus, WireColor color, CrossSection crossSection) {
        super(name, manufacturer, price, quantity, stockStatus);
        this.color = color;
        this.crossSection = crossSection;
    }

    @Override
    public String getInfo() {
        return color + " " + name + " " + crossSection.toString();
    }

    public WireColor getColor() {
        return color;
    }

    public CrossSection getCrossSection() {
        return crossSection;
    }

}
