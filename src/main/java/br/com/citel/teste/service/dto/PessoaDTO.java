package br.com.citel.teste.service.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSetter;

import br.com.citel.teste.model.enums.TipoPessoa;
import br.com.citel.teste.model.enums.TipoSanguineo;
import br.com.citel.teste.model.enums.TipoSexo;
import br.com.citel.teste.model.enums.TipoTelefone;

public class PessoaDTO {
    
    private Long id;

    private String nome;

    private String cpf;

    private String rg;

    private LocalDate dataNasc;

    private TipoSexo sexo;

    private String email;

    private BigDecimal altura;

    private BigDecimal peso;

    private TipoSanguineo tipoSanguineo;
    
    private TipoPessoa tipoPessoa;
    
    @JsonInclude(Include.NON_NULL)
    private String mae;
    
    @JsonInclude(Include.NON_NULL)
    private String pai;
    
    @JsonInclude(Include.NON_NULL)
    private String telefoneFixo;
    
    @JsonInclude(Include.NON_NULL)
    private String celular;
    
    @JsonInclude(Include.NON_NULL)
    private String cep;
   
    @JsonInclude(Include.NON_NULL)
    private String endereco;
    
    @JsonInclude(Include.NON_NULL)
    private Integer numero;
    
    @JsonInclude(Include.NON_NULL)
    private String bairro;
    
    @JsonInclude(Include.NON_NULL)
    private String cidade;
    
    @JsonInclude(Include.NON_NULL)
    private String estado;
    
    private List<EnderecoDTO> enderecos = new ArrayList<>();
    
    private List<TelefoneDTO> telefones  = new ArrayList<>();
    
    private List<PessoaDTO> pessoas  = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public PessoaDTO id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public PessoaDTO nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public PessoaDTO cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public PessoaDTO rg(String rg) {
        this.rg = rg;
        return this;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    @JsonSetter("data_nasc")
    public void setDataNasc(String dataNasc) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dataNasc = sdf.parse(dataNasc).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public PessoaDTO dataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
        return this;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = TipoSexo.valueOf(sexo.toUpperCase());
    }
    
    public PessoaDTO sexo(TipoSexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public PessoaDTO email(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }
    
    public PessoaDTO altura(BigDecimal altura) {
        this.altura = altura;
        return this;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    
    public PessoaDTO peso(BigDecimal peso) {
        this.peso = peso;
        return this;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    @JsonSetter("tipo_sanguineo")
    public void setTipoSanguineo(String tipoSanguineo) {
    	
    	switch (tipoSanguineo) {
			case "A+":
				this.tipoSanguineo = TipoSanguineo.A_POSITIVE;
				break;
			case "A-":
				this.tipoSanguineo = TipoSanguineo.A_NEGATIVE;
				break;
			case "B+":
				this.tipoSanguineo = TipoSanguineo.B_POSITIVE;
				break;
			case "B-":
				this.tipoSanguineo = TipoSanguineo.AB_NEGATIVE;
				break;
			case "AB+":
				this.tipoSanguineo = TipoSanguineo.AB_POSITIVE;
				break;
			case "AB-":
				this.tipoSanguineo = TipoSanguineo.AB_NEGATIVE;
				break;
			case "O+":
				this.tipoSanguineo = TipoSanguineo.O_POSITIVE;
				break;
			case "O-":
				this.tipoSanguineo = TipoSanguineo.O_NEGATIVE;
				break;
			default:
				this.tipoSanguineo = null;
		}
    	
    }
    
    public PessoaDTO tipoSanguineo(TipoSanguineo tipoSanguineo) {
    	this.tipoSanguineo = tipoSanguineo;
        return this;
    }
    
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public PessoaDTO tipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
		return this;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}
	
	public PessoaDTO mae(String mae) {
		this.mae = mae;
		return this;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}
	
	public PessoaDTO pai(String pai) {
		this.pai = pai;
		return this;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	@JsonSetter("telefone_fixo")
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
		this.telefones.add(new TelefoneDTO(telefoneFixo, TipoTelefone.FIXO));
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	
	public void addEndereco(EnderecoDTO endereco) {
		enderecos.add(endereco);
	}
	
	public void removeEndereco(EnderecoDTO endereco) {
		enderecos.remove(endereco);
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}
	
	public void addTelefone(TelefoneDTO telefone) {
		telefones.add(telefone);
	}

	public void removeTelefone(TelefoneDTO telefone) {
		telefones.remove(telefone);
	}

	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}

	public void addPessoa(PessoaDTO pessoa) {
		pessoas.add(pessoa);
	}
	
	public void removePessoa(PessoaDTO pessoa) {
		pessoas.remove(pessoa);
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
		this.telefones.add(new TelefoneDTO(celular, TipoTelefone.CELULAR));
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
}
