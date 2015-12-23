package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Controller {

    private DecimalFormat decimalFormat;
    public TextField inputNumber;
    public Label resultLabel;
    public Label obsLabel;

    public Controller() {
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setGroupingUsed(true);
    }

    public void converteNumero(ActionEvent actionEvent) {
        try {
            String numeroStr = inputNumber.getText().replace(".", "").replace(",", ".");

            BigDecimal valor = new BigDecimal(new Double(numeroStr));
            Numerals numerals = new Numerals(2);
            String numeroExtenso = numerals.toString(valor);
            resultLabel.setText(numeroExtenso);
            inputNumber.setText(decimalFormat.format(valor));

            BigDecimal diferenca = valor.subtract(new BigDecimal(valor.intValue()));
            if (diferenca.compareTo(BigDecimal.ZERO) > 0) {
                obsLabel.setText("N\u00E3o \u00E9 preciso preencher os valores de centavos no cheque".toUpperCase());
            } else {
                obsLabel.setText("");
            }

        } catch (NumberFormatException ex) {
            resultLabel.setText("Formato Num\u00E9rico Errado");
        }
    }

    public void limpar(ActionEvent actionEvent) {
        resultLabel.setText("");
        inputNumber.setText("");
        obsLabel.setText("");
    }
}
