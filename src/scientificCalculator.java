import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class scientificCalculator extends JFrame implements ActionListener {

    static double m1;                   //variable to hold the data of the memory button
    JTextField textField;               //Textfield to display answers and input
    double temp, temp1, result, a;
    int k = 1, x=0, y=0, z=0;
    char ch;
    //defining the buttons to be used on the calculator
    JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button0, buttonClr, buttonPow2, buttonPow3, buttonExp,buttonFac, buttonPlus, buttonMinus, buttonDiv, buttonLog10, buttonRec, buttonMul,
            buttonEq, buttonAddSub,buttonDot, buttonMr, buttonMc, buttonMp, buttonMm, buttonSqrt, buttonSin, buttonCos, buttonTan, buttonArcsin, buttonArccos, buttonArctan, buttonNlog,buttonLog2, buttonBToD, buttonDToB;
    Container container;
    JPanel textPanel, buttonPanel; //Setting up panels to hold the buttons and textfiel
    String binary, tempBinary; //variables to hold the binary string

    //Constructor to set up all the buttons and textfield on the GUI
    public scientificCalculator() {

        container = getContentPane();
        container.setLayout(new BorderLayout()); //sets layout on the container
        textPanel = new JPanel();
        textField = new JTextField(27);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font("Arial",Font.BOLD,25));
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                char c = keyEvent.getKeyChar();
                if (c>='0' && c<='9'){

                }else {
                    keyEvent.consume();
                }
            }
        });
        textPanel.add(textField);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7,1,2,2)); //sets layout on the button panel

        //defining the buttons, adding the buttons onto the GUI and setting up the listeners for the buttons
        buttonMr = new JButton("MR");
        buttonMr.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMr);
        buttonMr.addActionListener(this);
        buttonMc = new JButton("MC");
        buttonMc.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMc);
        buttonMc.addActionListener(this);
        buttonMp = new JButton("M+");
        buttonMp.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMp);
        buttonMp.addActionListener(this);
        buttonMm = new JButton("M-");
        buttonMm.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMm);
        buttonMm.addActionListener(this);

        buttonBToD = new JButton("BtoD");
        buttonBToD.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonBToD);
        buttonBToD.addActionListener(this);
        buttonDToB = new JButton("DtoB");
        buttonDToB.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonDToB);
        buttonDToB.addActionListener(this);

        buttonRec = new JButton("1/x");
        buttonRec.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonRec);
        buttonRec.addActionListener(this);

        buttonPow2 = new JButton("x^2");
        buttonPow2.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonPow2);
        buttonPow2.addActionListener(this);
        buttonPow3 = new JButton("x^3");
        buttonPow3.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonPow3);
        buttonPow3.addActionListener(this);

        buttonExp = new JButton("Exp");
        buttonExp.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonExp);
        buttonExp.addActionListener(this);

        buttonFac = new JButton("n!");
        buttonFac.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonFac);
        buttonFac.addActionListener(this);

        buttonDiv = new JButton("/");
        buttonDiv.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonDiv);
        buttonDiv.addActionListener(this);

        buttonSin = new JButton("SIN");
        buttonSin.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonSin);
        buttonSin.addActionListener(this);
        buttonArcsin = new JButton("Arcsin");
        buttonArcsin.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonArcsin);
        buttonArcsin.addActionListener(this);

        button7 = new JButton("7");
        button7.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button7);
        button7.addActionListener(this);
        button8 = new JButton("8");
        button8.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button8);
        button8.addActionListener(this);
        button9 = new JButton("9");
        button9.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button9);
        button9.addActionListener(this);

        buttonMul = new JButton("*");
        buttonMul.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMul);
        buttonMul.addActionListener(this);

        buttonCos = new JButton("COS");
        buttonCos.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonCos);
        buttonCos.addActionListener(this);
        buttonArccos = new JButton("Arccos");
        buttonArccos.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonArccos);
        buttonArccos.addActionListener(this);

        button4 = new JButton("4");
        button4.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button4);
        button4.addActionListener(this);
        button5 = new JButton("5");
        button5.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button5);
        button5.addActionListener(this);
        button6 = new JButton("6");
        button6.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button6);
        button6.addActionListener(this);

        buttonMinus = new JButton("-");
        buttonMinus.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonMinus);
        buttonMinus.addActionListener(this);

        buttonTan = new JButton("TAN");
        buttonTan.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonTan);
        buttonTan.addActionListener(this);
        buttonArctan = new JButton("Arctan");
        buttonArctan.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonArctan);
        buttonArctan.addActionListener(this);

        button1 = new JButton("1");
        button1.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button1);
        button1.addActionListener(this);
        button2 = new JButton("2");
        button2.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button2);
        button2.addActionListener(this);
        button3 = new JButton("3");
        button3.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button3);
        button3.addActionListener(this);

        buttonPlus = new JButton("+");
        buttonPlus.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonPlus);
        buttonPlus.addActionListener(this);

        buttonSqrt = new JButton("Sqrt");
        buttonSqrt.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonSqrt);
        buttonSqrt.addActionListener(this);

        buttonAddSub = new JButton("+/-");
        buttonAddSub.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonAddSub);
        buttonAddSub.addActionListener(this);

        buttonClr = new JButton("AC");
        buttonClr.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonClr);
        buttonClr.addActionListener(this);

        button0 = new JButton("0");
        button0.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(button0);
        button0.addActionListener(this);

        buttonDot = new JButton(".");
        buttonDot.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonDot);
        buttonDot.addActionListener(this);
        buttonEq = new JButton("=");
        buttonEq.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonEq);
        buttonEq.addActionListener(this);

        buttonLog10 = new JButton("log10");
        buttonLog10.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonLog10);
        buttonLog10.addActionListener(this);
        buttonLog2 = new JButton("log2");
        buttonLog2.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonLog2);
        buttonLog2.addActionListener(this);
        buttonNlog = new JButton("Nlog");
        buttonNlog.setFont(new Font("SansSerif",Font.BOLD,18));
        buttonPanel.add(buttonNlog);
        buttonNlog.addActionListener(this);

        container.add("Center",buttonPanel);
        container.add("North",textPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //main function
    public static void main(String[] args){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //gets the screen size
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.synth"); //sets the look of the GUI
        }catch (Exception e){

        }
        //defines the scientific calculator window and some properties of the window
        scientificCalculator calc = new scientificCalculator();
        calc.setTitle("Scientific Calculator");
        calc.pack();
        calc.setVisible(true);
        calc.setSize(600,400);
        calc.setResizable(false);
        calc.setLocationRelativeTo(null);
        calc.setLocation(dimension.width/2-calc.getSize().width/2,dimension.height/2-calc.getSize().height/2); //sets location to the middle of the screen
        //defines the function graphing window ans some properties of the window
        JFrame grapher = new JFrame();
        FunctionGraph functionGraph = new FunctionGraph();
        grapher.add(functionGraph);
        functionGraph.init();
        //grapher.setResizable(false);
        grapher.pack();
        grapher.setVisible(true);
        grapher.setSize(700,600);
        grapher.setLocation((calc.getX()+calc.getWidth()), calc.getY()); // sets location to the right of the scientific calculator window

    }

    //default function which is called when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand(); //variable to hold the button string

        //switch statement which checks the variable s and gives output depending on which button is pressed
        switch (s) {
            //the number cases
            case "0" :
                if (z == 0) {
                    textField.setText(textField.getText() + "0");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "0");
                    z = 0;
                }
                break;
            case "1":
                if (z == 0) {
                    textField.setText(textField.getText() + "1");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "1");
                    z = 0;
                }
                break;
            case "2":
                if (z == 0) {
                    textField.setText(textField.getText() + "2");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "2");
                    z = 0;
                }
                break;
            case "3" :
                if (z == 0) {
                    textField.setText(textField.getText() + "3");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "3");
                    z = 0;
                }
                break;
            case "4" :
                if (z == 0) {
                    textField.setText(textField.getText() + "4");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "4");
                    z = 0;
                }
                break;
            case "5" :
                if (z == 0) {
                    textField.setText(textField.getText() + "5");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "5");
                    z = 0;
                }
                break;
            case "6":
                if (z == 0) {
                    textField.setText(textField.getText() + "6");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "6");
                    z = 0;
                }
                break;
            case "7" :
                if (z == 0) {
                    textField.setText(textField.getText() + "7");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "7");
                    z = 0;
                }
                break;
            case "8":
                if (z == 0) {
                    textField.setText(textField.getText() + "8");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "8");
                    z = 0;
                }
                break;
            case "9" :
                if (z == 0) {
                    textField.setText(textField.getText() + "9");
                } else {
                    textField.setText("");
                    textField.setText(textField.getText() + "9");
                    z = 0;
                }
                break;
            //the all clear case
            case "AC" :
                textField.setText("");
                x = 0;
                y = 0;
                z = 0;
                break;
            //the logarithmic cases
            case "log10" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.log(Double.parseDouble(textField.getText())) / Math.log(10);
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "log2":
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.log(Double.parseDouble(textField.getText())) / Math.log(2);
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "Nlog" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.log(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "1/x" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = 1 / Double.parseDouble(textField.getText());
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "Exp" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.exp(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            //the exponential cases
            case "x^2" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.pow(Double.parseDouble(textField.getText()), 2);
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "x^3" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.pow((Double.parseDouble(textField.getText())), 3);
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "+/-" :
                if (x == 0) {
                    textField.setText("-" + textField.getText());
                    x = 1;
                } else {
                    textField.setText(textField.getText());
                }
                break;
            case "." :
                if (y == 0) {
                    textField.setText(textField.getText() + ".");
                    y = 1;
                } else {
                    textField.setText(textField.getText());
                }
                break;
            //basic mathematical operations
            case "+" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                    temp = 0;
                    ch = '+';
                } else {
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    ch = '+';
                    y = 0;
                    x = 0;
                }
                textField.requestFocus();
                break;
            case "-":
                if (textField.getText().equals("")) {
                    textField.setText("");
                    temp = 0;
                    ch = '-';
                } else {
                    y = 0;
                    x = 0;
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    ch = '-';

                }
                textField.requestFocus();
                break;
            case "/" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                    temp = 1;
                    ch = '/';
                } else {
                    y = 0;
                    x = 0;
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    ch = '/';

                }
                textField.requestFocus();
                break;
            case "*" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                    temp = 0;
                    ch = '*';
                } else {
                    y = 0;
                    x = 0;
                    temp = Double.parseDouble(textField.getText());
                    textField.setText("");
                    ch = '*';

                }
                textField.requestFocus();
                break;
            //the memory function cases
            case "MC":
                m1 = 0;
                textField.setText("");
                break;
            case "MR":
                textField.setText("");
                textField.setText(textField.getText() + m1);
                break;
            case "M+" :
                if (k == 1) {
                    m1 = Double.parseDouble(textField.getText());
                    k++;
                } else {
                    m1 += Double.parseDouble(textField.getText());
                    textField.setText("" + m1);
                }
                break;
            case "M-" :
                if (k == 1) {
                    m1 = Double.parseDouble(textField.getText());
                    k++;
                } else {
                    m1 -= Double.parseDouble(textField.getText());
                    textField.setText("" + m1);
                }
                break;
            case "Sqrt":
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.sqrt(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            //the trigonometric cases
            case "SIN" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.sin(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "COS":
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.cos(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "TAN" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.tan(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "Arcsin" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.asin(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "Arccos" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.acos(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            case "Arctan" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = Math.atan(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            //the decimal to binary case
            case "DtoB":
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    tempBinary = textField.getText();
                    tempBinary = tempBinary.indexOf(".")<0? tempBinary : tempBinary.replaceAll("0*$","").replaceAll("\\.$","");
                    binary = Integer.toBinaryString(Integer.parseInt(tempBinary));
                    textField.setText("");
                    textField.setText(textField.getText() + binary);
                }
                break;
            //the binary to decimal case
            case "BtoD" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = toDecimal(textField.getText());
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
            //the equal case
            case "=" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    temp1 = Double.parseDouble(textField.getText());
                    switch (ch) {
                        case '+':
                            result = temp + temp1;
                            break;
                        case '-':
                            result = temp = temp1;
                            break;
                        case '/':
                            result = temp / temp1;
                            break;
                        case '*':
                            result = temp * temp1;
                            break;
                    }
                    textField.setText("");
                    textField.setText(textField.getText() + result);
                    z = 1;
                }
                break;
            //the factorial case
            case "n!" :
                if (textField.getText().equals("")) {
                    textField.setText("");
                } else {
                    a = fact(Double.parseDouble(textField.getText()));
                    textField.setText("");
                    textField.setText(textField.getText() + a);
                }
                break;
        }
        textField.requestFocus();
    }

    //function to compute the factorial of a number
    private double fact(double x){
        if (x<0){
            return 0;
        }
        double i, s=1;
        for (i=2;i<=x;i+=1.0){
            s *=i;
        }
        return s;
    }

    //function to convert a binary number to integer
    private double toDecimal(String s){
        int exp = Integer.MIN_VALUE;
        long value = 0;
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (ch=='.'){
                exp = 0;
            }else {
                value = value*2+ch -'0';
                exp++;
            }

        }
        return exp<0?value:Math.scalb(value,-exp);
    }

}