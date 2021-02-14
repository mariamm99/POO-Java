package gestisimal.vistas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gestisimal.Almacen;
import gestisimal.Articulo;
import gestisimal.CodigoNoExisteException;
import gestisimal.ExistenciasNegativasException;
import gestisimal.PrecioNegativoException;
import gestisimal.Exporta;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

public class almacenController implements Initializable {

  @FXML
  private TextField cod;

  @FXML
  private TextField descripcion;

  @FXML
  private TextField precioCompra;

  @FXML
  private TextField precioVenta;

  @FXML
  private TextField stock;

  @FXML
  private TextArea resultado;

  @FXML
  private TextField cambioStock;

  @FXML
  private Button boton;

  @FXML
  private Menu MLista;

  @FXML
  private Menu MOpciones;

  @FXML
  private Menu MUtilidades;

  @FXML
  private TextField rOperaciones;

  @FXML
  private RadioButton csv;

  @FXML
  private RadioButton html;

  @FXML
  private RadioButton json;

  @FXML
  private ToggleGroup grupo;

  @FXML
  private TableView<Articulo> table;

  @FXML
  private TableColumn<Articulo, Integer> column1;

  @FXML
  private TableColumn<Articulo, String> column2;

  @FXML
  private TableColumn<Articulo, Float> column3;

  @FXML
  private TableColumn<Articulo, Float> column4;

  @FXML
  private TableColumn<Articulo, Integer> column5;

  @FXML
  private ScrollBar scrollbar;
  
  static int codigo=0;

  static Almacen almacen = new Almacen();

  static boolean altaArticulos = false;

  Exporta exportar = new Exporta();

  @FXML
  private int getCodigo() {
    return Integer.parseInt(cod.getText());
  }

  @FXML
  private int getStock() {
    return Integer.parseInt(stock.getText());
  }

  @FXML
  private float getPrecioVenta() {
    return Float.parseFloat(precioVenta.getText());
  }

  @FXML
  private float getPrecioCompra() {
    return Float.parseFloat(precioCompra.getText());
  }

  @FXML
  private String getDescripcion() {
    return descripcion.getText();
  }

  @FXML
  void VentanaListar(ActionEvent event) throws IOException {
    Stage stage = new Stage();
    stage.setTitle("Listar");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("listar.fxml"));
    Pane root = fxml.<Pane>load();

    stage.setScene(new Scene(root));

    stage.show();

  }

  @FXML
  void recargarTabla() {
    for (Articulo articulo : almacen) {
      table.getItems().add(articulo);
    }
  }

  @FXML
  void menuTexto(Event event) {
    String id = ((Menu) event.getSource()).getId();

    if (id.equals(MLista.getId())) {
      resultado.setText("Mustra los árticulos de dos formas: mostrando una lista con todos o viendo de uno en uno");

    } else if (id.equals(MOpciones.getId())) {
      resultado.setText("Permite dar de alta, de baja, modificar articulos, ademas puedes aumentar y reducir su stock");

    } else if (id.equals(MUtilidades.getId())) {
      resultado.setText("Para exportar o importar los datos aun fichero y salir");
    }
  }

  @FXML
  void limparResultado(Event event) {
    resultado.setText("");
  }

  @FXML
  void VentanaAlta(ActionEvent event) throws IOException {
    Stage stageAlta = new Stage();
    stageAlta.setTitle("Alta");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("alta.fxml"));
    Pane root = fxml.<Pane>load();
    stageAlta.setScene(new Scene(root, 400, 400));
    stageAlta.showAndWait();

  }

  @FXML
  private void Alta(ActionEvent event) {

    try {
      almacen.alta(getDescripcion(), getPrecioCompra(), getPrecioVenta(), getStock());

    } catch (NumberFormatException | ExistenciasNegativasException | PrecioNegativoException e1) {
      System.err.println("error: " + e1.getMessage());
    }
    cerrarPantalla();

  }

  @FXML
  void VentanaBaja(ActionEvent event) throws IOException {

    Stage stageBaja = new Stage();
    stageBaja.setTitle("Dar de Baja");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("baja.fxml"));

    Pane root = fxml.<Pane>load();
    stageBaja.setScene(new Scene(root));
    stageBaja.showAndWait();
  }

  @FXML
  void Baja(ActionEvent event) {
    if (!almacen.baja(getCodigo())) {
      rOperaciones.setText("no se ha dado de baja, codigo no existe");
    } else {
      cerrarPantalla();
    }

  }

  @FXML
  void ventanaModificarCod(ActionEvent event) throws IOException {

    Stage stageBaja = new Stage();
    stageBaja.setTitle("Modificar");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("modificarCod.fxml"));

    Pane root = fxml.<Pane>load();
    stageBaja.setScene(new Scene(root));
    stageBaja.showAndWait();
    
  }
  
  @FXML
  public void guardarCodigo() throws IOException {
    codigo=getCodigo();
    ventanaModificar();
  }

  @FXML
  public void ventanaModificar() throws IOException {

    Stage stageBaja = new Stage();
    stageBaja.setTitle("Modificar");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("modificar.fxml"));

    Pane root = fxml.<Pane>load();
    stageBaja.setScene(new Scene(root));
    stageBaja.showAndWait();
  }

  @FXML
  public void modificar(ActionEvent event) {
    try {
System.out.println(codigo);
      almacen.get(codigo).set(new Articulo(getDescripcion(), getPrecioCompra(), getPrecioVenta(), getStock()));

    } catch (PrecioNegativoException | ExistenciasNegativasException e) {

      System.err.println("error en los datos " + e.getMessage());
    }
    cerrarPantalla();
  }


  @FXML
  void VentanaMasStock(ActionEvent event) throws IOException {

    Stage stageMasStock = new Stage();
    stageMasStock.setTitle("Aumentar el stock");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("MasStock.fxml"));

    Pane root = fxml.<Pane>load();
    stageMasStock.setScene(new Scene(root));
    stageMasStock.showAndWait();
  }

  @FXML
  void masStock(ActionEvent event) {

    try {
      almacen.masMercancia(getCodigo(), Integer.parseInt(cambioStock.getText()));
    } catch (ExistenciasNegativasException e) {
      System.out.println("error " + e.getMessage());
    }

    cerrarPantalla();
  }

  @FXML
  void VentanaMenosStock(ActionEvent event) throws IOException {

    Stage stageMenosStock = new Stage();
    stageMenosStock.setTitle("Decrementar el stock");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("MenosStock.fxml"));

    Pane root = fxml.<Pane>load();
    stageMenosStock.setScene(new Scene(root));
    stageMenosStock.showAndWait();
  }

  @FXML
  void menosStock(ActionEvent event) {
    try {
      almacen.menosMercancia(getCodigo(), Integer.parseInt(cambioStock.getText()));
    } catch (NumberFormatException | ExistenciasNegativasException e) {
      System.out.println("error " + e.getMessage());
    }
    cerrarPantalla();
  }

  @FXML
  void salir(ActionEvent event) {
    System.exit(0);
  }

  @FXML
  void website(ActionEvent event) throws IOException {

    Stage stageWeb = new Stage();
    stageWeb.setTitle("Github");

    WebView webView = new WebView();
    Pane root = new Pane(webView);

    webView.getEngine().load("https://github.com/mariamm99");
    stageWeb.setScene(new Scene(root));
    stageWeb.show();
  }

  @FXML
  void resumen(ActionEvent event) {

    Stage stage = new Stage();

    stage.setTitle("Creating popup");

    // create a button
    Button button = new Button("button");

    // create a tile pane
    Pane tilepane = new Pane();

    // create a label
    Label label = new Label(
        "Programa para manegar un Almacén, puedes listar los articulos, dar de Alta, de baja, modificarlo, cambiar el stock del Artículo o importar y exportar los datos a archivos.");

    // create a popup
    Popup popup = new Popup();

    // add the label
    popup.getContent().add(label);

    // set size of label
    label.setMinWidth(80);
    label.setMinHeight(50);

    // action event
    EventHandler<ActionEvent> pulsoboton = new EventHandler<ActionEvent>() {

      public void handle(ActionEvent e) {
        if (!popup.isShowing())
          popup.show(stage);
        else
          popup.hide();
      }
    };

    // when button is pressed
    button.setOnAction(pulsoboton);

    // add button
    tilepane.getChildren().add(button);

    // create a scene
    Scene scene = new Scene(tilepane, 200, 200);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  void listaIndividual(ActionEvent event) throws IOException {
    Stage stageListar = new Stage();
    stageListar.setTitle("Lista Individual");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("listaIndividual.fxml"));

    BorderPane root = fxml.<BorderPane>load();

    stageListar.setScene(new Scene(root));
    stageListar.show();

  }

  @FXML
  private void cerrarPantalla() {
    Stage stage = (Stage) boton.getScene().getWindow();
    stage.close();
  }

  @FXML
  void VentanaExporta(ActionEvent event) throws IOException {

    Stage stageMasStock = new Stage();
    stageMasStock.setTitle("Exportar");

    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("exporta.fxml"));

    Pane root = fxml.<Pane>load();
    stageMasStock.setScene(new Scene(root));
    stageMasStock.showAndWait();
  }

  @FXML
  void exporta(ActionEvent event) {

    // creamos arraylist con los articulos pq asi lo teniamos creado antes
    ArrayList<Articulo> articulos = new ArrayList<Articulo>();

    for (Articulo articulo : almacen) {
      articulos.add(articulo);
    }

    try {
      if (json.isSelected()) {
        exportar.exportaJson(articulos, guardarFichero());
      } else if (csv.isSelected()) {
        exportar.exportaCsv(articulos, guardarFichero());
      } else if (html.isSelected()) {
        exportar.exportaXML(articulos, guardarFichero());
      } else {
        System.out.println("No se ha seleccionado ningun archivo");
      }

    } catch (IOException e) {
      System.out.println("error no se ha podido guardar el fichero");
    }
  }

  @FXML
  String guardarFichero() {

    FileChooser fileChooser = new FileChooser();

//    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("text", "*.text"));

    fileChooser.setTitle("Open Resource File");
    Window stage = null;
    File file = fileChooser.showSaveDialog(stage);

    String fichero = file.toString();

    return fichero;

  }

  @FXML
  private File abrirFichero() {
    FileChooser fileChooser = new FileChooser();

    // indicamos extension del archivo
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

    fileChooser.setTitle("Open Resource File");
    Window stage = null;
    File file = fileChooser.showOpenDialog(stage);
    return file;
  }

  @FXML
  private void importa() {

    ArrayList<Articulo> articulos = new ArrayList<Articulo>();

    for (Articulo articulo : almacen) {
      articulos.add(articulo);
    }

    try {

      String cod = "";
      String descripcion = "";
      String pCompra = "";
      String pVenta = "";
      String stock = "";

      BufferedReader leer = new BufferedReader(new FileReader(abrirFichero()));
      String texto = leer.readLine();
      texto = leer.readLine();
      while (texto != null) {

        String a[] = texto.split(",");
        int i = 0;
        for (String string : a) {

          if (i == 0) {
            System.out.println(string + " ///");
            cod = string;
          } else if (i == 1) {
            System.out.println(string + " ///");
            descripcion = string;
          } else if (i == 2) {
            System.out.println(string + " ///");
            pCompra = string;
          } else if (i == 3) {
            System.out.println(string + " ///");
            pVenta = string;
          } else if (i == 4) {
            System.out.println(string + " ///");
            stock = string;
          }

          if (i < 4) {
            i++;

          } else {

            almacen.alta(descripcion, Float.parseFloat(pCompra), Float.parseFloat(pVenta), Integer.parseInt(stock));
            i = 0;
            texto = leer.readLine();
          }
        }
      }
    } catch (NumberFormatException | IOException | ExistenciasNegativasException | PrecioNegativoException e) {
      System.out.println("error: " + e.getMessage());
    }
  }

  private void recargarDatos(Articulo articulo) {
    cod.setText(articulo.getCodigo() + "");
    descripcion.setText(articulo.getDescripcion());
    precioCompra.setText(articulo.getPrecioCompra() + "");
    precioVenta.setText(articulo.getPrecioVenta() + "");
    stock.setText(articulo.getStock() + "");
  }

  @FXML
  public void listarIndividualScroll() {
    int tamannoAlmacen = 0;
    int indice = 0;

    for (Articulo articulo : almacen) {
      tamannoAlmacen++;
    }

    scrollbar.valueProperty().addListener((obs, oVal, nVal) -> {
      long index = Math.round((double) nVal);
      long cIx = 1;
      for (Articulo articulo : almacen) {
        if (cIx == index) {
          recargarDatos(articulo);
          break;
        }
        cIx++;
      }
    });

    scrollbar.setMin(1);
    scrollbar.setMax(tamannoAlmacen);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    if (!altaArticulos) {
      try {
        almacen.anadir();

      } catch (ExistenciasNegativasException | PrecioNegativoException e) {
        System.out.println("articulos de prueba no debe entrar aqui");
      }
      altaArticulos = true;
    }

    if (table != null) {
      column1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
      column2.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
      column3.setCellValueFactory(new PropertyValueFactory<>("precioCompra"));
      column4.setCellValueFactory(new PropertyValueFactory<>("precioVenta"));
      column5.setCellValueFactory(new PropertyValueFactory<>("stock"));
      recargarTabla();
    }

    if (scrollbar != null) {
      listarIndividualScroll();
    }
  }

}
