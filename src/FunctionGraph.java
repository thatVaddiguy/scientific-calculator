import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


public class FunctionGraph extends Applet implements ActionListener{

    FunctionGraphCanvas graph;  // The canvas that will display the graph.

    TextField functionInput;  // A text input box

    Label message;  //label for displaying messages to the user

    // Initialize the applet
    public void init() {

        setBackground(Color.black);
        setLayout(new BorderLayout(5,5));

        graph = new FunctionGraphCanvas();
        add(graph, BorderLayout.CENTER);

        message = new Label(" Enter a function and press enter");
        message.setBackground(Color.white);
        message.setForeground(Color.red);
        add(message, BorderLayout.NORTH);

        functionInput = new TextField();
        functionInput.setBackground(Color.white);
        functionInput.addActionListener(this);
        add(functionInput, BorderLayout.SOUTH);

    }

    //setting the border for the applet
    public Insets getInsets() {

        return new Insets(10,10,10,10);
    }

    //This is called when the user presses the enter button
    public void actionPerformed(ActionEvent evt) {

        Expr function;  // the expression inputted by the user

        try {
            String def = functionInput.getText();
            function = new Expr(def);
            graph.setFunction(function);
            message.setText(" Enter a function and press enter");
        }
        catch (IllegalArgumentException e) {
            graph.clearFunction();
            message.setText(e.getMessage());
        }

    }

}

//FunctionGraphCanvas displays the graph of a function on the x-y plane
class FunctionGraphCanvas extends Canvas {

    Expr func;  // The function that needs to be graphed

    //Constructor
    FunctionGraphCanvas() {
        setBackground(Color.white);
        func = null;
    }

    //setting the function to the canvas
    public void setFunction(Expr exp) {
        func = exp;
        repaint();
    }

    //clears the canvas
    public void clearFunction() {
        func = null;
        repaint();
    }


    public void paint(Graphics g) {
        // Draw the graph of the function or, if func is null,
        // display a message that there is no function to be graphed.
        if (func == null) {
            g.drawString("No function is available.", 20, 30);
        }
        else {
            g.drawString("y = " + func.getDefinition(), 5, 15);
            drawAxis(g);
            drawFunction(g);
        }
    }

    //Draws the x and y axis
    void drawAxis(Graphics g) {
        int width = getSize().width;
        int height = getSize().height;
        g.setColor(Color.blue);
        g.drawLine(5, height/2, width-5, height/2);
        g.drawLine(width/2, 5, width/2, height-5);
        g.drawString("x",8,(height/2)-50);
        g.drawString("y",(width/2)-50,8);
    }

    //Draws the function by finding put 301 coordinates of the function
    void drawFunction(Graphics g) {

        double x, y;          // variables to hold the x and y coordinates
        double prevx, prevy;  // variables to hold the previous x and y coordinates

        double dx;  // difference in the x values

        dx  = 10.0 / 300;

        g.setColor(new Color(0,59,111));

        x = -5;
        y = func.value(x);


        //loop to calculate the 301 points depending on the function and draw lines between them
        for (int i = 1; i <= 300; i++) {

            prevx = x;           // Save the coords of the previous point.
            prevy = y;

            x += dx;            // Get the coords of the next point.
            y = func.value(x);

            if ( (! Double.isNaN(y)) && (! Double.isNaN(prevy)) ) {
                // Draw a line segment between the two points.
                putLine(g, prevx, prevy, x, y);
            }

        }

    }

    //draws a line from (x1,y1) to (x2,y2)
    void putLine(Graphics g, double x1, double y1, double x2, double y2) {


        int a1, b1;   // Pixel coordinates of (x1,y1).
        int a2, b2;   // Pixel coordinates of (x2,y2).

        int width = getSize().width;     // Width of the canvas.
        int height = getSize().height;   // Height of the canvas.

        a1 = (int)( (x1 + 5) / 10 * width );
        b1 = (int)( (5 - y1) / 10 * height );
        a2 = (int)( (x2 + 5) / 10 * width );
        b2 = (int)( (5 - y2) / 10 * height );

        g.drawLine(a1,b1,a2,b2);

    }

}