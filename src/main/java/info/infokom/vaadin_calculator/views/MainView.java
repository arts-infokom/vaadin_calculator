package info.infokom.vaadin_calculator.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import info.infokom.vaadin_calculator.views.TaschenrechnerUI;

@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        TaschenrechnerUI taschenrechner = new TaschenrechnerUI();
        add(taschenrechner);
    }
}
