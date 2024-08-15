
import java.awt.Cursor;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author hoan3
 */
public class WeatherAppGui extends JFrame{
    public WeatherAppGui(){
        // set up our gui and add a title 
        super("Weather App");
        
        //configure gui to end the program's process once it has been closed 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // set the size of our gui (in pixels)
        setSize(450, 650);
        
        // load our gui at the center of the screen
        setLocationRelativeTo(null);
        
        // make our layout manager null to manually position our components within the gui
        setLayout(null);
        
        // prevent any resize of our gui
        setResizable(false);
        
        addGuiComponents();
        
        
    }
    
    private void addGuiComponents(){
        // search field
        JTextField searchTextField = new JTextField();
        
        // set the location and size of our component
        searchTextField.setBounds(15,15,351,45);
        
        // change the font style and size 
        searchTextField.setFont(new Font("Dialog", Font.PLAIN,24));
        
        add(searchTextField);
        
        
        //search button
        JButton searchButton = new JButton(loadImage("src/assets/weatherapp_images/search.png"));
        
        //change the cursor to a hand cursor when hovering over this button
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13, 47,45);
        
        add(searchButton);
        
        // weather image
        JLabel weatherConditionImage = new JLabel(loadImage("src/assets/weatherapp_images/cloudy.png"));
        weatherConditionImage.setBounds(0, 125, 450, 217);
        add(weatherConditionImage);
        
        // temperature text
        JLabel temperatureText = new JLabel("10 C");
        temperatureText.setBounds(0, 350, 450, 54);
        temperatureText.setFont(new Font("Dialog", Font.BOLD, 48));
        
        // center the text
        temperatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temperatureText);
        
        // weather condition description
        JLabel weatherConditionDesc = new JLabel("Cloudy");
        weatherConditionDesc.setBounds(0, 405, 450, 36);
        weatherConditionDesc.setFont(new Font("Dialog",Font.PLAIN,32));
        weatherConditionDesc.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);
        
        // humidity image
        JLabel humidityImage = new JLabel(loadImage("src/assets/weatherapp_images/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);
        
        // humidity text
        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90, 500, 85, 55);
        humidityText.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(humidityText);
        
        // winspeed image
        JLabel winspeedImage = new JLabel(loadImage("src/assets/weatherapp_images/windspeed.png"));
        winspeedImage.setBounds(220, 500, 74, 66);
        add(winspeedImage);
        
        // winspeed text
        JLabel winspeedText = new JLabel("<html><b>Windspeed</b> 15km/h</html>");
        winspeedText.setBounds(310, 500, 85, 55);
        winspeedText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(winspeedText);
    }
    
    // used to create image in our gui components
    private ImageIcon loadImage(String resourcePath){
        try {
            //read the image file from the path given
            BufferedImage image = ImageIO.read(new File(resourcePath));
            
            // return an image icon so that our component can render it
            return new ImageIcon(image);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Could not find resource");
        return null;
    }
    
    
    
}
