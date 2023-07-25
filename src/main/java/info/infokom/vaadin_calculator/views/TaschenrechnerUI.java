package info.infokom.vaadin_calculator.views;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import info.infokom.vaadin_calculator.service.CalculatorService;

@CssImport(value = "./styles/taschenrechner.css", themeFor = "vaadin-button")
public class TaschenrechnerUI extends Board {
    private TextField display;
    private String value1 = "";
    private String value2 = "";
    private String operation = "";
    private boolean isValue1 = true;
    private CalculatorService calculatorService = new CalculatorService();

    public TaschenrechnerUI() {
        display = new TextField();
        display.setReadOnly(true);
        display.addClassName("text-field");

        getStyle().set("padding", "2rem");
        getStyle().set("margin", "0 auto");
        getStyle().set("border", "2px solid black");
        getStyle().set("border-radius", "15px");

        display.setWidth("100%");
        display.setHeight("60px");
        display.getStyle()
                .set("font-size", "24px")
                .set("text-align", "right")
                .set("margin", "5px")
                .set("background-color", "#f9f9f9")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");

        Button button1 = createNumberButton("1");
        Button button2 = createNumberButton("2");
        Button button3 = createNumberButton("3");
        Button button4 = createNumberButton("4");
        Button button5 = createNumberButton("5");
        Button button6 = createNumberButton("6");
        Button button7 = createNumberButton("7");
        Button button8 = createNumberButton("8");
        Button button9 = createNumberButton("9");
        Button button0 = createNumberButton("0");

        Button addButton = createOperationButton("+");
        Button subtractButton = createOperationButton("-");
        Button multiplyButton = createOperationButton("*");
        Button divideButton = createOperationButton("/");
        Button negateButton = createOperationButton("±");
        Button decimalButton = createOperationButton(".");
        Button powerButton = createOperationButton("^");
        Button percentageButton = createOperationButton("%");
        Button calculateButton = new Button("=");
        calculateButton.addClickListener(event -> performCalculation());
        Style calculateButtonStyle = calculateButton.getStyle();
        calculateButtonStyle.set("width", "60px")
                .set("height", "60px")
                .set("font-size", "24px")
                .set("margin", "5px")
                .set("background-color", "#6db33f")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");

        HorizontalLayout row1 = new HorizontalLayout();
        row1.add(button1, button2, button3, addButton, powerButton);
        add(row1);

        HorizontalLayout row2 = new HorizontalLayout();
        row2.add(button4, button5, button6, subtractButton, negateButton);
        add(row2);

        HorizontalLayout row3 = new HorizontalLayout();
        row3.add(button7, button8, button9, multiplyButton, divideButton);
        add(row3);

        HorizontalLayout row4 = new HorizontalLayout();
        row4.add(createClearButton("C"), button0, decimalButton, calculateButton, percentageButton);
        add(row4);

        add(display);
    }

    private void performCalculation() {
        switch (operation) {
            case "+" -> {
                value1 = calculatorService.add(value1, value2);
                display.setValue(value1);
                value2 = "";
                operation = "";
            }
            case "-" -> System.out.println(value1 + " " + operation + " " + value2);
            case "*" -> System.out.println(value1 + " " + operation + " " + value2);
            case "/" -> System.out.println(value1 + " " + operation + " " + value2);
            case "^" -> System.out.println(value1 + " " + operation + " " + value2);
            case "%" -> System.out.println(value1 + " " + operation + " " + value2);
        }
    }



    private Button createNumberButton(String number) {
        Button btn = new Button(number, event -> {
            appendToDisplay(number);
            if (isValue1){
                value1 += number;
            } else {
                value2 += number;
            }
        });
        Style style = btn.getStyle();
        style.set("width", "60px")
                .set("height", "60px")
                .set("font-size", "24px")
                .set("margin", "5px")
                .set("background-color", "#f0f0f0")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");
        return btn;
    }

    private Button createOperationButton(String operation) {
        Button btn = new Button(operation, event -> {
            appendToDisplay(operation);
            this.operation = operation;
            isValue1 = false;
        });
        Style style = btn.getStyle();
        style.set("width", "60px")
                .set("height", "60px")
                .set("font-size", "24px")
                .set("margin", "5px")
                .set("background-color", "#c9c9c9")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");
        btn.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        return btn;
    }

    private Button createClearButton(String operation) {
        Button btn = new Button(operation, event -> clearDisplay());
        Style style = btn.getStyle();
        style.set("width", "60px")
                .set("height", "60px")
                .set("font-size", "24px")
                .set("margin", "5px")
                .set("background-color", "#ff5252")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");
        return btn;
    }

    private Button createPercentageButton(String operation) {
        Button btn = new Button(operation, event -> appendToDisplay(operation));
        Style style = btn.getStyle();
        style.set("width", "60px")
                .set("height", "60px")
                .set("font-size", "24px")
                .set("margin", "5px")
                .set("background-color", "#c9c9c9")
                .set("border", "1px solid #ccc")
                .set("border-radius", "5px");
        return btn;
    }

    private void appendToDisplay(String value) {
        display.setValue(display.getValue() + value);
    }

    private void clearDisplay() {
        value1 = "";
        value2 = "";
        operation = "";
        isValue1 = true;
        display.clear();
    }
}
