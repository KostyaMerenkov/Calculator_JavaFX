package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class ControllerС {
    static private boolean isPlus = true;
    private double a = 0;
    private double b = 0;
    private int operation = 0;
    DecimalFormat decimalFormat = new DecimalFormat("#.#########");
    @FXML
    private TextField calcHistory;
    @FXML
    private TextField calcEnter;


    public void clickNum(ActionEvent actionEvent) {
        calcEnter.appendText(((Button)actionEvent.getSource()).getText());
    }

    public void clearAll(ActionEvent actionEvent) {
        calcEnter.clear();
        calcHistory.clear();
        a = 0; b = 0; operation = 0;
        isPlus = true;
    }


    public void clickDot(ActionEvent actionEvent) {
        if (calcEnter.getText() != "" || calcEnter.getText() != "-") {
            calcEnter.appendText(",");
        }
    }

    public void clickMulti(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText(calcEnter.getText() + " * ");
            calcEnter.clear();
            operation = 3;
        }
    }

    public void clickDivide(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText(calcEnter.getText() + " / ");
            calcEnter.clear();
            operation = 4;
        }

    }

    public void clickPlus(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText(calcEnter.getText() + " + ");
            calcEnter.clear();
            operation = 1;
        }


    }

    public void clickMinus(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText(calcEnter.getText() + " - ");
            calcEnter.clear();
            operation = 2;
        }
        else {
            calcEnter.setText("-");
            isPlus = false;
        }

    }

    public void clickPM(ActionEvent actionEvent) {
            if (isPlus) {
                calcEnter.setText("-"+calcEnter.getText());
                isPlus = false;
            }
            else {
                calcEnter.setText(calcEnter.getText().substring(1));
                isPlus = true;
            }


    }

    public void clickDelete(ActionEvent actionEvent) {
        try {
            calcEnter.setText(calcEnter.getText().substring(0,calcEnter.getText().length()-1));
        } catch (StringIndexOutOfBoundsException s) {
            System.out.println(s.getMessage());
        }
    }

    public void clickSqrtX(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText("√" + decimalFormat.format(a));
            calcEnter.setText(String.format(decimalFormat.format((Math.sqrt(a)))));
        }

    }

    public void clickX2(ActionEvent actionEvent) {
        if (calcEnter.getText() != "") {
            a = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            calcHistory.setText(calcEnter.getText() + "² = ");
        }
        calcEnter.setText(String.format(decimalFormat.format((a*a))));
    }

    public void clickResult(ActionEvent actionEvent)  {
        if (a != 0 & calcHistory.getText() != "")
        {
            b = Double.parseDouble(calcEnter.getText().replaceAll(",", "."));
            switch (operation)
            {
                case 1:
                {
                    a = a + b;
                    calcEnter.setText(String.format(decimalFormat.format(a)));
                    calcHistory.appendText(String.format(decimalFormat.format(b)) + " = ");
                    a=0;
                    break;
                }
                case 2:
                {
                    a = a - b;
                    calcEnter.setText(String.format(decimalFormat.format(a)));
                    calcHistory.appendText(String.format(decimalFormat.format(b)) + " = ");
                    a=0;
                    break;
                }
                case 3:
                {
                    a = a * b;
                    calcEnter.setText(String.format(decimalFormat.format(a)));
                    calcHistory.appendText(String.format(decimalFormat.format(b)) + " = ");
                    a=0;
                    break;
                }
                case 4:
                {
                    double div;
                    div = Double.parseDouble(calcEnter.getText());
                    if (div == 0.0)
                        calcEnter.setText("Error! (Divide by zero)");
                    else
                    {
                        a = a / b;
                        calcEnter.setText(String.format(decimalFormat.format(a)));
                    }
                    calcHistory.appendText(String.format(decimalFormat.format(b)) + " = ");
                    a=0;
                    break;
                }
            }
        }
    }
}
