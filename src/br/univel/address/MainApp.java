package br.univel.address;

import java.io.IOException;

import br.univel.address.model.Pessoa;
import br.univel.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    // ... APÓS AS OUTRAS VARIÁVEIS ...

    /**
     * Os dados como uma observable list de Persons.
     */
    private ObservableList<Pessoa> pessoaData = FXCollections.observableArrayList();

    /**
     * Construtor
     */
    public MainApp() {
        // Add some sample data
        pessoaData.add(new Pessoa("Hans", "Muster"));
        pessoaData.add(new Pessoa("Ruth", "Mueller"));
        pessoaData.add(new Pessoa("Heinz", "Kurz"));
        pessoaData.add(new Pessoa("Cornelia", "Meier"));
        pessoaData.add(new Pessoa("Werner", "Meyer"));
        pessoaData.add(new Pessoa("Lydia", "Kunz"));
        pessoaData.add(new Pessoa("Anna", "Best"));
        pessoaData.add(new Pessoa("Stefan", "Meier"));
        pessoaData.add(new Pessoa("Martin", "Mueller"));
    }

    /**
     * Retorna os dados como uma observable list de Persons. 
     * @return
     */
    public ObservableList<Pessoa> getPessoaData() {
        return pessoaData;
    }

    // ... O RESTANTE DA CLASSE ...
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo oroot layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
     */
    /**
     * Mostra a person overview dentro do root layout.
     */
    public void showPersonOverview() {
        try {
            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define a person overview no centro do root layout.
            rootLayout.setCenter(personOverview);

            // Dá ao controlador acesso à the main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}