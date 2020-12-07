package br.com.citel.teste.model;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import br.com.citel.teste.model.enums.TipoPessoa;
import br.com.citel.teste.model.enums.TipoSanguineo;
import br.com.citel.teste.model.enums.TipoSexo;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private TipoSexo sexo;

    @Column(name = "email")
    private String email;

    @Column(name = "altura")
    private BigDecimal altura;

    @Column(name = "peso")
    private BigDecimal peso;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sanguineo")
    private TipoSanguineo tipoSanguineo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
    private List<Endereco> enderecos = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
    private List<Telefone> telefones = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pessoa_id")
    private List<Pessoa> pessoas = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Pessoa id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Pessoa nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Pessoa cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public Pessoa rg(String rg) {
        this.rg = rg;
        return this;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    public Pessoa dataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
        return this;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }
    
    public Pessoa sexo(TipoSexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Pessoa email(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }
    
    public Pessoa altura(BigDecimal altura) {
        this.altura = altura;
        return this;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    
    public Pessoa peso(BigDecimal peso) {
        this.peso = peso;
        return this;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public Pessoa tipoSanguineo(TipoSanguineo tipoSanguineo) {
    	this.tipoSanguineo = tipoSanguineo;
        return this;
    }

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public Pessoa tipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
		return this;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}
	
	public void removeEndereco(Endereco endereco) {
		enderecos.remove(endereco);
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public void addTelefone(Telefone telefone) {
		telefones.add(telefone);
	}

	public void removeTelefone(Telefone telefone) {
		telefones.remove(telefone);
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public void removePessoa(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	
	public BigDecimal calculateImc() {
		return peso.divide(altura.multiply(altura), 2, RoundingMode.HALF_UP);
	}
	
	public Integer calculateAge() {
		return Period.between(dataNasc, LocalDate.now()).getYears();
	}


}
