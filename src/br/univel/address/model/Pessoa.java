package br.univel.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Model para uma Person (pessoa).
 *
 * @author Marco Jakob
 */
public class Pessoa {

    private final StringProperty Nome;
    private final StringProperty Sobrenome;
    private final StringProperty Endereco;
    private final IntegerProperty CodPostal;
    private final StringProperty Cidade;
    private final ObjectProperty<LocalDate> DatNasc;

    /**
     *  Construtor padrão.
     */
    public Pessoa() {
        this(null, null);
    }

    /**
     * Construtor com alguns dados iniciais.
     * 
     * @param firstName Primeiro nome da Pessoa.
     * @param lastName Sobrenome da Pessoa.
     */
    public Pessoa(String Nome, String Sobrenome) {
        this.Nome = new SimpleStringProperty(Nome);
        this.Sobrenome = new SimpleStringProperty(Sobrenome);

        // Alguns dados de exemplo, apenas para testes.
        this.Endereco = new SimpleStringProperty("some street");
        this.CodPostal = new SimpleIntegerProperty(1234);
        this.Cidade = new SimpleStringProperty("some city");
        this.DatNasc = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getNome() {
        return Nome.get();
    }

    public void setNome(String Nome) {
        this.Nome.set(Nome);
    }
    
    public StringProperty NomeProperty() {
        return Nome;
    }

    public String getSobrenome() {
        return Sobrenome.get();
    }

    public void setLastName(String Sobrenome) {
        this.Sobrenome.set(Sobrenome);
    }

    public StringProperty SobrenomeProperty() {
        return Sobrenome;
    }

    public String getEndereco() {
        return Endereco.get();
    }

    public void setEndereco(String Endereco) {
        this.Endereco.set(Endereco);
    }

    public StringProperty EnderecoProperty() {
        return Endereco;
    }

    public int getCodPostal() {
        return CodPostal.get();
    }

    public void setPostalCode(int CodPostal) {
        this.CodPostal.set(CodPostal);
    }

    public IntegerProperty CodPostalProperty() {
        return CodPostal;
    }

    public String getCidade() {
        return Cidade.get();
    }

    public void setCidade(String Cidade) {
        this.Cidade.set(Cidade);
    }

    public StringProperty CidadeProperty() {
        return Cidade;
    }

    public LocalDate getDatNasc() {
        return DatNasc.get();
    }

    public void setDatNasc(LocalDate DatNasc) {
        this.DatNasc.set(DatNasc);
    }

    public ObjectProperty<LocalDate> DatNascProperty() {
        return DatNasc;
    }
}