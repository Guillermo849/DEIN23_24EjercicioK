package controllers;

/* Aplicación que muestra un reloj animado */

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.time.LocalDateTime;

public class RelojController implements Initializable {

    @FXML
    private ImageView imgHDec;

    @FXML
    private ImageView imgHCen;

    @FXML
    private ImageView imgMinDec;

    @FXML
    private ImageView imgMinCen;

    @FXML
    private ImageView imgSegDec;

    @FXML
    private ImageView imgSegCen;
    
    /* Inicializa la hora en la que se inicia la aplicación y marca 
     *   cuando pasan los segundos, minutos y horas */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		LocalDateTime tiempo = LocalDateTime.now();
		
		obtenerNumero(tiempo.getSecond(), imgSegDec, imgSegCen);
		obtenerNumero(tiempo.getMinute(), imgMinDec, imgMinCen);
		obtenerNumero(tiempo.getHour(), imgHDec, imgHCen);
		
		Timer timer = new Timer();
		
		TimerTask segundos = new TimerTask() {
			
			@Override
			public void run() {
				LocalDateTime tiempo = LocalDateTime.now();
				// TODO Auto-generated method stub
				obtenerNumero(tiempo.getSecond(), imgSegDec, imgSegCen);
				if (tiempo.getSecond() == 0) {
					obtenerNumero(tiempo.getMinute(), imgMinDec, imgMinCen);
				}
				if (tiempo.getMinute() == 0) {
					obtenerNumero(tiempo.getHour(), imgHDec, imgHCen);
				}
			}
		};
		
		
		/* Cada segundo se ejecutara el timertask segundos */
		timer.schedule(segundos, 0, 1000);
	}
	
	/* Obtiene los numeros de la hora, minuto o segundo y los divide en 
	 *  decimales y centesimas*/
	private void obtenerNumero(int valorTiempo, ImageView imgDec, ImageView imgCen) {
		
		int cen = valorTiempo%10;
		
		int dec = (valorTiempo/10)%10;
		
		cambiarNumero(cen, imgCen);
		cambiarNumero(dec, imgDec);
	}
	
	/* Cambia las imagenes de la ImageView Correspondiente */
	private void cambiarNumero(int num, ImageView img) {
		
		switch (num) {
		case 0: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/ZERO.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 1: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/ONE.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 2: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/TWO.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 3: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/THREE.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 4: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/FOUR.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 5: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/FIVE.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 6: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/SIX.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 7: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/SEVEN.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 8: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/EIGHT.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} case 9: {
			String ruta = Paths.get(".").toAbsolutePath().normalize().toString()
					+"/resources/img/NINE.png";
			File file = new File(ruta);
			img.setImage(new Image(file.toURI().toString()));
			break;
		} 
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
	}
}
