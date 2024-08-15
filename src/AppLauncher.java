
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoan3
 */
public class AppLauncher {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                // display our weather app gui
//                new WeatherAppGui().setVisible(true);
                java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.2");
                 System.out.println(WeatherApp.getLocationData("Berlin"));
            }
        });
    }
}
